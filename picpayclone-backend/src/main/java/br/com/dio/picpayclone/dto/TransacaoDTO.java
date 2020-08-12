package br.com.dio.picpayclone.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TransacaoDTO {

	@NotBlank
	private String codigo;
	
	@NotNull
	private UsuarioDTO origem;
	
	@NotNull
	private UsuarioDTO destino;
	
	@NotNull
	private LocalDateTime dataHora;
	
	@NotNull
	private Double valor;
	
	private CartaoCreditoDTO cartaoCredito;
	
	private Boolean isCartaoCredito = false;

	public TransacaoDTO(@NotBlank String codigo, @NotNull UsuarioDTO origem, @NotNull UsuarioDTO destino,
			@NotNull LocalDateTime dataHora, @NotNull Double valor, CartaoCreditoDTO cartaoCredito,
			Boolean isCartaoCredito) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.dataHora = dataHora;
		this.valor = valor;
		this.cartaoCredito = cartaoCredito;
		this.isCartaoCredito = isCartaoCredito;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public UsuarioDTO getOrigem() {
		return origem;
	}

	public void setOrigem(UsuarioDTO origem) {
		this.origem = origem;
	}

	public UsuarioDTO getDestino() {
		return destino;
	}

	public void setDestino(UsuarioDTO destino) {
		this.destino = destino;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CartaoCreditoDTO getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCreditoDTO cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Boolean getIsCartaoCredito() {
		return isCartaoCredito;
	}

	public void setIsCartaoCredito(Boolean isCartaoCredito) {
		this.isCartaoCredito = isCartaoCredito;
	}
	
}
