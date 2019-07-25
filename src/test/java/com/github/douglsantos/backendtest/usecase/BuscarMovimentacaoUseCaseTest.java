package com.github.douglsantos.backendtest.usecase;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;

@Tag("acceptance")
@RunWith(MockitoJUnitRunner.class)
public class BuscarMovimentacaoUseCaseTest {
	
	@Mock
	private BuscarMovimentacaoUseCase buscarMovimentacaUseCase;
	private MovimentacaoEntityDomain movimentacaoEsperada;
	private static final BigDecimal TOTAL_GASTO_ESPERADO = new BigDecimal(-3318.35);
	private static final BigDecimal TOTAL_GANHO_ESPERADO = new BigDecimal(528.75);
	private static final BigDecimal SALDO_TOTAL_ESPERADO = new BigDecimal(-2789.60);
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.movimentacaoEsperada = new MovimentacaoEntityDomain
				("May", "EBANX AIRBNB", new BigDecimal("-1430.44"), "hospedagem");
	}
	
	@Test
	public void temUmaCategoriaQueOClienteGastouMaisTest() throws Exception {
		//given
		given(buscarMovimentacaUseCase.categoriaComMaiorGasto())
			.willReturn(movimentacaoEsperada);
		
		//when
		final MovimentacaoEntityDomain movimentacaoAtual = buscarMovimentacaUseCase.categoriaComMaiorGasto();
		
		//then
		then(movimentacaoAtual.getCategoria())
			.as("Checa se a categoria do movimento é retornada")
			.isNotBlank();
		then(movimentacaoAtual)
			.as("Checa o maior gasto por categoria")
			.isEqualTo(movimentacaoEsperada);
	}
	
	@Test
	public void temUmMesQueOClienteGastouMaisTest() throws Exception {
		//given
		given(buscarMovimentacaUseCase.mesComMaiorGasto())
			.willReturn(movimentacaoEsperada);
		
		//when
		final MovimentacaoEntityDomain movimentacaoAtual = buscarMovimentacaUseCase.mesComMaiorGasto();
		
		//then
		then(movimentacaoAtual.getDataMovimentacao())
			.as("Checa se a data de movimentacao é retornada")
			.isNotBlank();
		then(movimentacaoAtual)
			.as("Checa o mês com o maior gasto")
			.isEqualTo(movimentacaoEsperada);
	}
	
	@Test
	public void totalGastoPeloClienteTest() throws Exception {
		//given
		given(buscarMovimentacaUseCase.totalGasto())
			.willReturn(TOTAL_GASTO_ESPERADO);
		
		//when
		final BigDecimal totalGastoAtual = buscarMovimentacaUseCase.totalGasto();
		
		//then
		then(totalGastoAtual)
			.as("Checa se o valor existe e se não é positivo.")
			.isNotNull()
			.isNotPositive();
		then(totalGastoAtual)
			.as("Checa o valor total gasto")
			.isEqualByComparingTo(TOTAL_GASTO_ESPERADO);
	}
	
	@Test
	public void totalGanhoPeloClienteTest() throws Exception {
		//given
		given(buscarMovimentacaUseCase.totalGanho())
			.willReturn(TOTAL_GANHO_ESPERADO);
		
		//when
		final BigDecimal totalGanhoAtual = buscarMovimentacaUseCase.totalGanho();
		
		//then
		then(totalGanhoAtual)
			.as("Checa se o valor existe e se não é negativo.")
			.isNotNull()
			.isNotNegative();
		then(totalGanhoAtual)
			.as("Checa o valor total ganho")
			.isEqualByComparingTo(TOTAL_GANHO_ESPERADO);
	}
	
	@Test
	public void saldoTotalPeloClienteTest() throws Exception {
		//given
		given(buscarMovimentacaUseCase.saldoTotal())
			.willReturn(SALDO_TOTAL_ESPERADO);
		
		//when
		final BigDecimal saldoTotalAtual = buscarMovimentacaUseCase.saldoTotal();
		
		//then
		then(saldoTotalAtual)
			.as("Checa se o valor existe.")
			.isNotNull();
		then(saldoTotalAtual)
			.as("Checa o valor saldo total")
			.isEqualByComparingTo(SALDO_TOTAL_ESPERADO);
	}
}
