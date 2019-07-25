package com.github.douglsantos.backendtest.dataprovider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;
import com.github.douglsantos.backendtest.usecase.gateway.BuscarMovimentacaoGateway;

@Tag("integration")
public class BuscarMovimentacaoDataProviderTest {
	private BuscarMovimentacaoGateway buscarMovimentacaoGateway = new BuscarMovimentacaoDataProvider();

	@Test
	@DisplayName("Testa a leitura do arquivo movimentacao.log para buscar as movimentações do cliente")
	public void testarLeituraArquivoLogParaBuscarMovimentacaoTest() throws Exception {
		List<MovimentacaoEntityDomain> movimentacoes = buscarMovimentacaoGateway
				.buscarMovimentacao();

		for(int i = 0; i < mockMovimentacoes().size(); i++) {
			
			assertThat(mockMovimentacoes().get(i).getDataMovimentacao(), 
					is(movimentacoes.get(i).getDataMovimentacao()));
			
			assertThat(mockMovimentacoes().get(i).getDescricacao(), 
					is(movimentacoes.get(i).getDescricacao()));
			
			assertThat(mockMovimentacoes().get(i).getValor(), 
					is(movimentacoes.get(i).getValor()));
			
			assertThat(mockMovimentacoes().get(i).getCategoria(), 
					is(movimentacoes.get(i).getCategoria()));

		}

	}
	
	private List<MovimentacaoEntityDomain> mockMovimentacoes() {
		List<MovimentacaoEntityDomain> movimentacoes = buscarMovimentacaoGateway
				.buscarMovimentacao();
		return movimentacoes;
	}

}
