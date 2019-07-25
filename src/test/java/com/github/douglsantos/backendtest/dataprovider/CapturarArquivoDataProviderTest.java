package com.github.douglsantos.backendtest.dataprovider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class CapturarArquivoDataProviderTest {
	
	@Test
	@DisplayName("Testa o cenário caso o arquvo solicitado não exista")
	public void testarFalhaLeituraArquivoLogParaBuscarMovimentacaoTest() throws Exception {

		FileNotFoundException exception = assertThrows(FileNotFoundException.class,
				() -> {

					CapturarArquivoDataProvider.capturarLog("extrato.log");

					}
				);

		assertEquals("extrato.log (Arquivo ou diretório inexistente)", exception.getMessage());
	}
}
