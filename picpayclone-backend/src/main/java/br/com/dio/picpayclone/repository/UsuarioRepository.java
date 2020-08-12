package br.com.dio.picpayclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.dio.picpayclone.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);

	@Modifying
	@Query("UPDATE Usuario u SET u.saldo = u.saldo - ?2 WHERE u.login = ?1")
	void updateDecrementarSaldo(String login, Double valor);

	@Modifying
	@Query("UPDATE Usuario u SET u.saldo + ?2 WHERE u.login = ?1")
	void updateIncrementarSaldo(String login, Double valor);

}
