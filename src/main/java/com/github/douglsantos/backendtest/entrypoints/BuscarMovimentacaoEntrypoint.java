package com.github.douglsantos.backendtest.entrypoints;

import com.github.douglsantos.backendtest.entrypoints.entity.response.MovimentacaoEntityResponse;
import com.github.douglsantos.backendtest.usecase.BuscarMovimentacaoUseCase;
import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;

/**
 * Classe responsavel por exibir os valores da movimentação do cliente
 * 
 * @author Douglas Santos
 *
 */
public class BuscarMovimentacaoEntrypoint {
	
	private BuscarMovimentacaoUseCase buscarMovimentacaoUseCase = new BuscarMovimentacaoUseCase();
	
	/**
	 * Metodo responsável por consumir a camada de negócio (use case) e,
	 * exibir no console os dados de movimentação agrupando pela categoria com
	 * maior gasto.
	 */
	public void categoriaComMaiorGasto() {
		MovimentacaoEntityResponse movimentacaoResponse = to(buscarMovimentacaoUseCase.categoriaComMaiorGasto());
				
		System.out.println("categoria que o cliente gastou mais: " + movimentacaoResponse.getCategoria());
		System.out.println("valor: " + movimentacaoResponse.getValor());
	}
	
	/**
	 * Metodo responsável por consumir a camada de negócio (use case) e,
	 * exibir no console os dados de movimentação agrupando pelo mês com
	 * maior gasto.
	 */
	public void mesComMaiorGasto() {
		MovimentacaoEntityResponse movimentacaoResponse = to(buscarMovimentacaoUseCase.mesComMaiorGasto());
				
		System.out.println("mês que o cliente gastou mais: " + movimentacaoResponse.getDataMovimentacao());
		System.out.println("valor: " + movimentacaoResponse.getValor());
	}
	
	/**
	 * Metodo responsaǘel por consumir a camada de negócio (use case) e,
	 * exibir no console os dados de movimentação com total gasto pelo cliente
	 */
	public void totalGasto() {
		System.out.println("total gasto pelo cliente: " + buscarMovimentacaoUseCase.totalGasto());
	}
	
	/**
	 * Metodo responsaǘel por consumir a camada de negócio (use case) e,
	 * exibir no console os dados de movimentação com total ganho pelo cliente
	 */
	public void totalGanho() {
		System.out.println("total ganho pelo cliente: " + buscarMovimentacaoUseCase.totalGanho());
	}
	
	/**
	 * Metodo responsaǘel por consumir a camada de negócio (use case) e,
	 * exibir no console os dados de movimentação com saldo total do cliente
	 */
	public void saldoTotal() {
		System.out.println("saldo total do cliente: " + buscarMovimentacaoUseCase.saldoTotal());
	}
	
	/**
	 * Mapper responsável por converter uma entitidade do dominio de neǵocio (use case) para
	 * uma entidade de resposta da camada de apresentação (entrypoint)
	 * 
	 * @param domain
	 * @return {@link MovimentacaoEntityResponse}
	 */
	private MovimentacaoEntityResponse to(MovimentacaoEntityDomain domain) {
		return new MovimentacaoEntityResponse(
				domain.getDataMovimentacao(), 
				domain.getCategoria(), 
				domain.getValor());
	}
	
}
