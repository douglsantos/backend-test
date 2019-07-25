package com.github.douglsantos.backendtest.dataprovider;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.github.douglsantos.backendtest.dataprovider.entity.response.MovimentacaoEntityResponse;
import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;
import com.github.douglsantos.backendtest.usecase.gateway.BuscarMovimentacaoGateway;

/**
 * Camada que representa o DataProvider responsável pela comunicação com fonte de dados
 * externas a aplicação. Por exemplo: Banco de Dados, Arquivos, API REST e etc.s
 * 
 * @author Douglas Santos
 */
public class BuscarMovimentacaoDataProvider implements BuscarMovimentacaoGateway {

	private static final String FILE = "movimentacao.log";
	
	@Override
	public List<MovimentacaoEntityDomain> buscarMovimentacao() {
		List<MovimentacaoEntityDomain> movimentacoes = new ArrayList<>();
		
		for (MovimentacaoEntityResponse response : toMovimentacaoEntityResponse()) {
			MovimentacaoEntityDomain entityDomain = new MovimentacaoEntityDomain();
			entityDomain.setDataMovimentacao(response.getDataMovimentacao());
			entityDomain.setDescricacao(response.getDescricacao());
			entityDomain.setValor(response.getValor());
			entityDomain.setCategoria(response.getCategoria());
			
			movimentacoes.add(entityDomain);
		}
		return movimentacoes;
	}
	
	/**
	 * Metodo responsável por tratar os dados obtidos do metodo {@link #capturarLog() capturarLog}.
	 * 
	 * @return List<MovimentacaoEntityResponse>
	 */
	private List<MovimentacaoEntityResponse> toMovimentacaoEntityResponse() {
		List<String> movimentacoesLog = null;
		try {
			movimentacoesLog = CapturarArquivoDataProvider.capturarLog(FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		List<MovimentacaoEntityResponse> movimentacoes = new ArrayList<>();

		for (int i = 1; i < movimentacoesLog.size(); i++) {
			
			/*
			 * Expressão regular usada para substituir todos os espaçoes que forem maior que 2 caracteres.
			 * Em seguida é realizado a quebra das Strings com o scape que representa uma nova linha.
			 */
			String[] data = movimentacoesLog.get(i).replaceAll("\\s{2,}", "\n").split("\n");

			MovimentacaoEntityResponse movimentacao = new MovimentacaoEntityResponse();

			/*
			 * Expressão regular que remover os dias e o caracter '-', assim normalizando os dados para
			 * serem tratados na camada de negócio.
			 */
			movimentacao.setDataMovimentacao(data[0].replaceAll("^+[0-9]{2,}-", ""));
			movimentacao.setDescricacao(data[1]);
			movimentacao.setValor(new BigDecimal(data[2].trim().replace(".", "").replace(",", ".")));
			
			/* uso de condição ternaria para caracterizar as categorias que estavam como nulas */
			movimentacao.setCategoria(data.length > 3 && data[3] != null ? data[3] : "sem categoria");
			
			movimentacoes.add(movimentacao);

		}

		return movimentacoes;

	}


}
