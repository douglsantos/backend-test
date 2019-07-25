package com.github.douglsantos.backendtest.usecase;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.douglsantos.backendtest.dataprovider.BuscarMovimentacaoDataProvider;
import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;
import com.github.douglsantos.backendtest.usecase.gateway.BuscarMovimentacaoGateway;

/**
 * Classe responsável por conter os metodos com as regras de negócio
 * 
 * @author Douglas Santos
 *
 */
public class BuscarMovimentacaoUseCase {
	
	private BuscarMovimentacaoGateway movimentacaoGateway = new BuscarMovimentacaoDataProvider();
	
	/**
	 * Metodo responsável por retornar a categoria com maior gasto.
	 * 
	 * @see Collections
	 * @see Comparator
	 * @return {@link MovimentacaoEntityDomain}
	 */
	public MovimentacaoEntityDomain categoriaComMaiorGasto() {
		List<MovimentacaoEntityDomain> movimentacoes = movimentacaoGateway.buscarMovimentacao();

		return Collections.min(movimentacoes, Comparator
				.comparing(movimentacao -> movimentacao.getValor()));
	}
	
	/**
	 * Metodo responsável por retornar a movimentação com o mês que teve o maior gasto.
	 * 
	 * @see Collections
	 * @see Collectors
	 * @see Comparator
	 * @return {@link MovimentacaoEntityDomain}
	 */
	public MovimentacaoEntityDomain mesComMaiorGasto() {
		List<MovimentacaoEntityDomain> movimentacoes = movimentacaoGateway.buscarMovimentacao();
		MovimentacaoEntityDomain entityDomain = new MovimentacaoEntityDomain();
		
		Map<String, BigDecimal> values = movimentacoes.stream()
				.collect(Collectors.groupingBy(MovimentacaoEntityDomain::getDataMovimentacao,
					Collectors.reducing(BigDecimal.ZERO, MovimentacaoEntityDomain::getValor, BigDecimal::add)));
		
		entityDomain.setDataMovimentacao(Collections.min(values.entrySet(), Comparator.comparing(mes -> mes.getValue())).getKey());
		entityDomain.setValor(Collections.min(values.entrySet(), Comparator.comparing(mes -> mes.getValue())).getValue());
		
		return entityDomain;
		
	}
	
	/**
	 * Metódo responsável por retornar o total dos gastos.
	 * 
	 * @see Collectors
	 * @return {@link BigDecimal}
	 */
	public BigDecimal totalGasto() {
		List<MovimentacaoEntityDomain> movimentacoes = movimentacaoGateway.buscarMovimentacao();

		return movimentacoes.stream()
				.filter(movimentacao -> movimentacao.getValor().signum() < 0)
				.collect(Collectors.reducing(BigDecimal.ZERO, MovimentacaoEntityDomain::getValor, BigDecimal::add));
		
	}
	
	/**
	 * Metódo responsável por retornar o total dos ganhos.
	 * 
	 * @see Collectors
	 * @return {@link BigDecimal}
	 */
	public BigDecimal totalGanho() {
		List<MovimentacaoEntityDomain> movimentacoes = movimentacaoGateway.buscarMovimentacao();

		return movimentacoes.stream()
			.filter(movimentacao -> movimentacao.getValor().signum() > 0)
			.collect(Collectors.reducing(BigDecimal.ZERO, MovimentacaoEntityDomain::getValor, BigDecimal::add));
		
	}
	
	/**
	 * Metódo responsável por retornar o saldo total do cliente.
	 * 
	 * @see Collectors
	 * @return {@link BigDecimal}
	 */
	public BigDecimal saldoTotal() {
		List<MovimentacaoEntityDomain> movimentacoes = movimentacaoGateway.buscarMovimentacao();
		
		return movimentacoes.stream()
				.collect(Collectors.reducing(BigDecimal.ZERO, MovimentacaoEntityDomain::getValor, BigDecimal::add));
	}
	

}
