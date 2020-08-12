package br.com.dio.picpayclone.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.dio.picpayclone.conversor.UsuarioConversor;
import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.domain.Usuario;
import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.exceptions.NegocioException;
import br.com.dio.picpayclone.repository.UsuarioRepository;
import br.com.dio.picpayclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioConversor usuarioConversor;
	
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

	@Override
	public UsuarioDTO consultar(String login) {
		Usuario consultar = consultarEntidade(login);
		
		return usuarioConversor.converterEntidadeParaDto(consultar);
	}

	@Override
	public List<UsuarioDTO> listar(String login) {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		List<Usuario> usuarioFiltrado = usuarios.stream()
			.filter(usuario -> !usuario.getLogin().equals(login))
			.collect(Collectors.toList());
		
		return usuarioConversor.converterEntidadesParaDtos(usuarioFiltrado);
	}

}
