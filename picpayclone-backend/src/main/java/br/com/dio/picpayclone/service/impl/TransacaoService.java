package br.com.dio.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.conversor.TransacaoConversor;
import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.service.ITransacaoService;

@Service
public class TransacaoService implements ITransacaoService {
	
	@Autowired
	private TransacaoConversor transacaoConversor;

	@Override
	public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
		Transacao transacao = salvar(transacaoDTO);
		
		cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
		usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito());
		
		return transacaoConversor.converterEntidadeParaDto(transacao);
	}

	private Transacao salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = transacaoConversor.converterDtoPataEntidade(transacaoDTO);
		
		usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
		
		return transacaoRepository.save(transacao);
	}
	
}
