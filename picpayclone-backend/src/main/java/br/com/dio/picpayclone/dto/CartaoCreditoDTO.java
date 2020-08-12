package br.com.dio.picpayclone.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.dio.picpayclone.enums.BandeiraCartao;

@JsonInclude(Include.NON_NULL)
public class CartaoCreditoDTO {

	@NotBlank
	private BandeiraCartao bandeira;
	
	@NotBlank
	private String codigoSeguranca;
	
	@NotBlank
	private String dataExpiracao;
	
	@NotBlank
	private String nomeTitular;
	
	private String numero;
	
	private String numeroToken;
	
	@NotNull
	private UsuarioDTO usuario;
	
	private Boolean isSalva = false;

	public CartaoCreditoDTO(@NotBlank BandeiraCartao bandeira, @NotBlank String codigoSeguranca,
			@NotBlank String dataExpiracao, @NotBlank String nomeTitular, String numero, String numeroToken,
			@NotNull UsuarioDTO usuario, Boolean isSalva) {
		super();
		this.bandeira = bandeira;
		this.codigoSeguranca = codigoSeguranca;
		this.dataExpiracao = dataExpiracao;
		this.nomeTitular = nomeTitular;
		this.numero = numero;
		this.numeroToken = numeroToken;
		this.usuario = usuario;
		this.isSalva = isSalva;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroToken() {
		return numeroToken;
	}

	public void setNumeroToken(String numeroToken) {
		this.numeroToken = numeroToken;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public Boolean getIsSalva() {
		return isSalva;
	}

	public void setIsSalva(Boolean isSalva) {
		this.isSalva = isSalva;
	}
	
}
