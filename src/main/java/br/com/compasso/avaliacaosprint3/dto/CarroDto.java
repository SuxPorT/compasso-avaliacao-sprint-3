package br.com.compasso.avaliacaosprint3.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.compasso.avaliacaosprint3.model.Carro;

public class CarroDto {

	private String chassi, nome, marca, cor;
	private BigDecimal valor;
	private Long anoFabricacao;
	
	public CarroDto(Carro carro) {
		this.chassi        = carro.getChassi();
		this.nome          = carro.getNome();
		this.marca         = carro.getMarca();
		this.cor           = carro.getCor();
		this.valor         = carro.getValor();
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
	
}
