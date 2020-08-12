package br.com.dio.picpayclone.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import br.com.dio.picpayclone.dto.TransacaoDTO;

public interface ITransacaoService {

	TransacaoDTO processar(TransacaoDTO transacaoDTO);

	Page<TransacaoDTO> listar(Pageable paginacao, String login);
	
}
