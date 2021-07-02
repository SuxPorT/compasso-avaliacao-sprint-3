package br.com.compasso.avaliacaosprint3.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.compasso.avaliacaosprint3.model.Carro;
import br.com.compasso.avaliacaosprint3.repository.CarroRepository;

public class CarroDto {

	private String chassi;
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private Long anoFabricacao;
	
	public CarroDto(Carro carro) {
		this.chassi = carro.getChassi();
		this.nome = carro.getNome();
		this.marca = carro.getMarca();
		this.cor = carro.getCor();
		this.valor = carro.getValor();
		this.anoFabricacao = carro.getAnoFabricacao();
	}

	public String getChassi() {
		return chassi;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getCor() {
		return cor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Long getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public static List<CarroDto> converter(List<Carro> carros) {
		return carros.stream().map(CarroDto::new).collect(Collectors.toList());
	}

	public static List<Carro> analisarParametros(CarroRepository carroRepository, Map<String, String> parametros) {
		List<Carro> carros = null;
		
		String 
			marca       = parametros.containsKey("marca") ? parametros.get("marca").toUpperCase() : null,
			nome        = parametros.containsKey("nome")  ? parametros.get("nome").toUpperCase()  : null,
			cor         = parametros.containsKey("cor")   ? parametros.get("cor").toUpperCase()   : null,
			ordenaPreco = parametros.containsKey("preco") ? parametros.get("preco").toUpperCase() : null,
			tipoOrd     = parametros.containsKey("ord")   ? parametros.get("ord").toUpperCase()   : null;
	
		System.out.println("marca: " + marca);
		System.out.println("nome: " + nome);
		
		if (marca != null && nome == null && cor == null && ordenaPreco == null && tipoOrd == null) {
			carros = carroRepository.findByMarca(marca);
		} else if (marca == null && nome != null && cor == null && ordenaPreco == null && tipoOrd == null) {
			carros = carroRepository.findByNome(nome);
		} else if (marca == null && nome == null && cor != null && ordenaPreco == null && tipoOrd == null) {
			carros = carroRepository.findByNome(cor);
		} else {
			carros = carroRepository.findAll();
		}
		
		return carros;
	}
	
}
