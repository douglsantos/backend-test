package com.github.douglsantos.backendtest;

import com.github.douglsantos.backendtest.entrypoints.BuscarMovimentacaoEntrypoint;

public class BootApplicationMovimentacao {
	/**
	 * Metodo que executa a aplicação
	 */

	public static void main(String[] args) {
		BuscarMovimentacaoEntrypoint entrypoint = new BuscarMovimentacaoEntrypoint();

		entrypoint.categoriaComMaiorGasto();
		System.out.println("--------------------------------------");
		entrypoint.mesComMaiorGasto();
		System.out.println("--------------------------------------");
		entrypoint.totalGasto();
		System.out.println("--------------------------------------");
		entrypoint.totalGanho();
		System.out.println("--------------------------------------");
		entrypoint.saldoTotal();
	}
}
