package br.com.dio.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.conversor.TransacaoConversor;
import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.repository.TransacaoRepository;
import br.com.dio.picpayclone.service.ICartaoCreditoService;
import br.com.dio.picpayclone.service.ITransacaoService;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class TransacaoService implements ITransacaoService {
	
	@Autowired
	private TransacaoConversor transacaoConversor;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ICartaoCreditoService cartaoCreditoService; 

	@Override
	public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
		Transacao transacao = salvar(transacaoDTO);
		
		cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
		usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito());
		
		return transacaoConversor.converterEntidadeParaDto(transacao);
	}

	private Transacao salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
		
		usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
		
		return transacaoRepository.save(transacao);
	}

	@Override
	public Page<TransacaoDTO> listar(Pageable paginacao, String login) {
		Page<Transacao> transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao); // WHERE Login OR WHERE Login
		
		return transacaoConversor.converterPageEntidadeParaDto(transacoes);
	}
	
}
