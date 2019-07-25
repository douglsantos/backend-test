package com.github.douglsantos.backendtest.usecase.gateway;

import java.util.List;

import com.github.douglsantos.backendtest.usecase.domain.MovimentacaoEntityDomain;

public interface BuscarMovimentacaoGateway {
	public List<MovimentacaoEntityDomain> buscarMovimentacao();
}
