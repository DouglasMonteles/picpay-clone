package br.com.dio.picpayclone.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario extends EntidadeBase {

	@Column(name = "USU_LOGIN", nullable = false)
	private String login;
	
	@Column(name = "USU_SENHA", nullable = false)
	private String senha;
	
	@Column(name = "USU_EMAIL", nullable = false)
	private String email;
	
	@Column(name = "USU_NOME_COMPLETO", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "USU_CPF", nullable = false)
	private String cpf;
	
	@Column(name = "USU_DATA_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "USU_NUMERO_TELEFONE", nullable = false)
	private String numeroTelefone;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<CartaoCredito> cartoesCredito;
	
	@Column(name = "USU_SALDO", nullable = false)
	private Double saldo;
	
	@Column(name = "USU_ATIVO", nullable = false)
	private Boolean ativo;

	public Usuario(String login, String senha, String email, String nomeCompleto, String cpf, LocalDate dataNascimento,
			String numeroTelefone, List<CartaoCredito> cartoesCredito, Double saldo, Boolean ativo) {
		super();
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.numeroTelefone = numeroTelefone;
		this.cartoesCredito = cartoesCredito;
		this.saldo = saldo;
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public List<CartaoCredito> getCartoesCredito() {
		return cartoesCredito;
	}

	public void setCartoesCredito(List<CartaoCredito> cartoesCredito) {
		this.cartoesCredito = cartoesCredito;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
}
