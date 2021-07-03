package br.com.compasso.avaliacaosprint3.controller.form;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.compasso.avaliacaosprint3.model.Carro;
import br.com.compasso.avaliacaosprint3.repository.CarroRepository;

public class AtualizacaoCarroForm {

	@NotNull @NotEmpty
	private String cor;
	
	@NotNull
	private BigDecimal valor;

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

	public Carro atualizar(Optional<Carro> optional, CarroRepository carroRepository) {
		Carro carro = optional.get();
		carro.setCor(this.cor);
		carro.setValor(this.valor);
		
		return carro;
	}
	
}
