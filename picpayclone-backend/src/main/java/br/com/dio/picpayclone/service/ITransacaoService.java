package br.com.dio.picpayclone.service;

import br.com.dio.picpayclone.dto.TransacaoDTO;

public interface ITransacaoService {

	TransacaoDTO processar(TransacaoDTO transacaoDTO);
	
}
