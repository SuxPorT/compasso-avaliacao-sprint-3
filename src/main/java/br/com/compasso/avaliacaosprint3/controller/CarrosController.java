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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.avaliacaosprint3.controller.form.AtualizacaoCarroForm;
import br.com.compasso.avaliacaosprint3.controller.form.CarroForm;
import br.com.compasso.avaliacaosprint3.dto.CarroDto;
import br.com.compasso.avaliacaosprint3.model.Carro;
import br.com.compasso.avaliacaosprint3.repository.CarroRepository;

//@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarrosController {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public List<CarroDto> listarComParametros(CarroForm form, Pageable pageable) {
		List<Carro> carros = carroRepository.findAll(form.toSpec(), pageable).getContent();
		
		return CarroDto.converter(carros);
	}
	
	@GetMapping
	public List<CarroDto> listar(@RequestParam Map<String, String> parametros, CarroForm form, Pageable pageable) {
		if (parametros.isEmpty()) {
			List<Carro> carros = (List<Carro>) carroRepository.findAll();
			
			return CarroDto.converter(carros);
		}
		
		return this.listarComParametros(form, pageable);
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
	
	@PutMapping("/{chassi}")
	@Transactional
	public ResponseEntity<CarroDto> atualizar(@PathVariable String chassi, @RequestBody @Valid AtualizacaoCarroForm form) {
		Optional<Carro> optional = carroRepository.findByChassi(chassi);
		
		if (optional.isPresent()) {
			Carro carro = form.atualizar(optional, carroRepository);
			
			return ResponseEntity.ok(new CarroDto(carro));
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
