package br.com.compasso.avaliacaosprint3.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.avaliacaosprint3.controller.form.CarroForm;
import br.com.compasso.avaliacaosprint3.dto.CarroDto;
import br.com.compasso.avaliacaosprint3.model.Carro;
import br.com.compasso.avaliacaosprint3.repository.CarroRepository;

@RestController
@RequestMapping("/api/cars")
public class CarrosController {
	
	@Autowired
	private CarroRepository carroRepository;

	@GetMapping
	public List<CarroDto> listar(@RequestParam Map<String, String> parametros) {
		System.out.println("Nenhum parâmetro = " + parametros.isEmpty());
		
		List<Carro> carros = null;
		
		if (parametros.isEmpty()) {
			carros = carroRepository.findAll();
			
			return CarroDto.converter(carros);
		}
		
		carros = CarroDto.analisarParametros(carroRepository, parametros);
		
		return CarroDto.converter(carros);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {
		Optional<Carro> chassiExistente = carroRepository.findByChassi(form.getChassi());
		
		if (chassiExistente.isEmpty()) {
			Carro carro = form.converter();
			carroRepository.save(carro);
			
			URI uri = uriBuilder.path("/cars/{chassi}").buildAndExpand(carro.getChassi()).toUri();
			
			return ResponseEntity.created(uri).body(new CarroDto(carro));
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{chassi}")
	public ResponseEntity<CarroDto> detalhar(@PathVariable String chassi) {
		Optional<Carro> carro = carroRepository.findByChassi(chassi.toUpperCase());
		
		if (carro.isPresent()) {
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{chassi}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String chassi) {
		Optional<Carro> optional = carroRepository.findByChassi(chassi.toUpperCase());
		
		if (optional.isPresent()) {
			carroRepository.deleteByChassi(chassi.toUpperCase());
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
