package br.com.compasso.avaliacaosprint3.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	
	private List<CarroDto> listarComParametros(CarroForm form, Pageable pageable) {
		List<Carro> carros = carroRepository.findAll(form.toSpec(), pageable).getContent();
		
		return CarroDto.converter(carros);
	}
	
	@GetMapping
	public List<CarroDto> listar(@RequestParam Map<String, String> parametros, CarroForm form, Pageable pageable) {
		List<Carro> carros = null;
		
		if (!parametros.isEmpty()) {

			if (parametros.containsKey("tipoValor")) {
				// Filta pelo carro mais barato/caro, porém não atua com os demais filtros
				String tipoValor = parametros.get("tipoValor");
					
				if (tipoValor.equals("min")) {
					carros = (List<Carro>) carroRepository.findByMinValor();
				} else {
					carros = (List<Carro>) carroRepository.findByMaxValor();
				}
				
				return CarroDto.converter(carros);
			}
	
			return this.listarComParametros(form, pageable);
		}
		
		carros = (List<Carro>) carroRepository.findAll();
		
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
		chassi = chassi.toUpperCase();
		
		Optional<Carro> carro = carroRepository.findByChassi(chassi);
		
		if (carro.isPresent()) {
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{chassi}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String chassi) {
		chassi = chassi.toUpperCase();
		
		Optional<Carro> optional = carroRepository.findByChassi(chassi);
		
		if (optional.isPresent()) {
			carroRepository.deleteById(chassi);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
