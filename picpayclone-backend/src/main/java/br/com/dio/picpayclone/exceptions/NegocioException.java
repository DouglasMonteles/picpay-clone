package br.com.dio.picpayclone.exceptions;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String msg) {
		super(msg);
	}
	
	public NegocioException(String msg, Exception cause) {
		super(msg, cause);
	}
	
}
