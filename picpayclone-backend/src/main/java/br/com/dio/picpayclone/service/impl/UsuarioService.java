package br.com.dio.picpayclone.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.domain.Usuario;
import br.com.dio.picpayclone.exceptions.NegocioException;
import br.com.dio.picpayclone.repository.UsuarioRepository;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario consultarEntidade(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public void validar(Usuario... usuarios) {
		Arrays.asList(usuarios)
			.stream()
			.forEach(usuario -> {
				if (usuario == null) {
					throw new NegocioException("O usuário informado não existe!");
				}
			});
		
	}

	@Override
	@Async("asyncExecutor")
	public void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito) {
		
		decrementarSaldo(transacao, isCartaoCredito);
		
		incrementarSaldo(transacao);
		
	}
	
	private void decrementarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito) {
		if (!isCartaoCredito) {
			usuarioRepository.updateDecrementarSaldo(transacaoSalva.getOrigem().getLogin(), transacaoSalva.getValor());
		}
	}
	
	private void incrementarSaldo(Transacao transacaoSalva) {
		usuarioRepository.updateIncrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor());
	}

}
