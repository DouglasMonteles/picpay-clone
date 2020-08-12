package br.com.dio.picpayclone.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACOES")
public class Transacao extends EntidadeBase {

	@Column(name = "TR_CODIGO", nullable = false)
	private String codigo;
	
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "TR_USUARIO_ORIGEM", nullable = false)
	private Usuario origem;
	
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@Column(name = "TR_USUARIO_DESTINO", nullable = false)
	private Usuario destino;
	
	@Column(name = "TR_DATA_HORA", nullable = false)
	private LocalDateTime dataHora;
	
	@Column(name = "TR_VALOR", nullable = false)
	private Double valor;

	public Transacao(String codigo, Usuario origem, Usuario destino, LocalDateTime dataHora, Double valor) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getOrigem() {
		return origem;
	}

	public void setOrigem(Usuario origem) {
		this.origem = origem;
	}

	public Usuario getDestino() {
		return destino;
	}

	public void setDestino(Usuario destino) {
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
	
}
