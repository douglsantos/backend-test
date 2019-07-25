package com.github.douglsantos.backendtest.dataprovider.entity.response;

import java.math.BigDecimal;

public class MovimentacaoEntityResponse {

	private String dataMovimentacao;
	private String descricacao;
	private BigDecimal valor;
	private String categoria;

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
		return "MovimentacaoEntityResponse [dataMovimentacao=" + dataMovimentacao + ", descricacao=" + descricacao
				+ ", valor=" + valor + ", categoria=" + categoria + "]";
	}

}
