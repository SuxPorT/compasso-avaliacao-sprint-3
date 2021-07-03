package br.com.compasso.avaliacaosprint3.config.validacao;

public class ErroFormularioDto {

	private String campo, erro;
	
	public ErroFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro  = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
