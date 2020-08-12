package br.com.dio.picpayclone.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ErrorDTO {

	private String campo;
	private String mensagem;
	
	public ErrorDTO(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
}
