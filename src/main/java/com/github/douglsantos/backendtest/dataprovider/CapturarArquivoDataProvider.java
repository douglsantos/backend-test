package com.github.douglsantos.backendtest.dataprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CapturarArquivoDataProvider {

	/**
	 * Realiza a leitura do arquivo movimentacao.log e adiciona cada linha em uma
	 * lista de String
	 * 
	 * @return List<String>
	 * @throws FileNotFoundException 
	 */
	public static List<String> capturarLog(String file) throws FileNotFoundException {
		List<String> movimentacoes = new ArrayList<>();

		Scanner scanArquivoLog = new Scanner(new FileReader(file));
		if (scanArquivoLog.hasNext()) {

			scanArquivoLog.useDelimiter("\\s");

			while (scanArquivoLog.hasNext()) {
				movimentacoes.add(scanArquivoLog.nextLine());

			}
			scanArquivoLog.close();
			return movimentacoes;
		}
		scanArquivoLog.close();
		throw new FileNotFoundException();
	}
}
