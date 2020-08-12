package br.com.dio.picpayclone.service;

import java.util.List;

import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.domain.Usuario;
import br.com.dio.picpayclone.dto.UsuarioDTO;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);

	void validar(Usuario... usuarios);

	void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);
	
	UsuarioDTO consultar(String login);
	
	List<UsuarioDTO> listar(String login);

}
