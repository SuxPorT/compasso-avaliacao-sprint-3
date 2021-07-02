package br.com.compasso.avaliacaosprint3.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.compasso.avaliacaosprint3.model.Carro;

public class CarroForm {

	@NotNull @NotEmpty @Length(min = 17, max = 18)
	private String chassi;
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String marca;
	
	@NotNull @NotEmpty
	private String cor;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull @Digits(integer = 4, fraction = 0) @Min(1900) @Max(2021)
	private Long anoFabricacao;

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Long anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public Carro converter() {
		return new Carro(this.chassi, this.nome, this.marca, this.cor, this.valor, this.anoFabricacao);
	}
	
}
