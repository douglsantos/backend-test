package com.github.douglsantos.backendtest.usecase.domain;

import java.math.BigDecimal;

public class MovimentacaoEntityDomain {

	private String dataMovimentacao;
	private String descricacao;
	private BigDecimal valor;
	private String categoria;

	public MovimentacaoEntityDomain(String dataMovimentacao, String descricacao, BigDecimal valor, String categoria) {
		this.dataMovimentacao = dataMovimentacao;
		this.descricacao = descricacao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public MovimentacaoEntityDomain() {
	}

	public String getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(String dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "MovimentacaoEntityDomain [dataMovimentacao=" + dataMovimentacao + ", descricacao=" + descricacao
				+ ", valor=" + valor + ", categoria=" + categoria + "]";
	}

}
