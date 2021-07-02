package br.com.compasso.avaliacaosprint3.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

	@Id
	private String chassi;
	
	private String nome;
	private String marca;
	private String cor;
	private BigDecimal valor;
	private Long anoFabricacao;
	
	public Carro() {
	}
	
	public Carro(String chassi, String nome, String marca, String cor, BigDecimal valor, Long anoFabricacao) {
		this.chassi = chassi.toUpperCase();
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
		this.valor = valor;
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
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
	
}
