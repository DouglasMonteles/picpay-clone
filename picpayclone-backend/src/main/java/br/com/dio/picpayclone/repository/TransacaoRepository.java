package br.com.dio.picpayclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.picpayclone.domain.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
