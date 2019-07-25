package com.github.douglsantos.backendtest.entrypoints.entity.response;

import java.math.BigDecimal;

public class MovimentacaoEntityResponse {

	private String dataMovimentacao;
	private String categoria;
	private BigDecimal valor;

	public MovimentacaoEntityResponse(String dataMovimentacao, String categoria, BigDecimal valor) {
		this.dataMovimentacao = dataMovimentacao;
		this.categoria = categoria;
		this.valor = valor;
	}

	public String getDataMovimentacao() {
		return dataMovimentacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
