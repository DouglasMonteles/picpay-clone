package br.com.dio.picpayclone.service;

import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.domain.Usuario;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);

	void validar(Usuario... usuarios);

	void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

}
