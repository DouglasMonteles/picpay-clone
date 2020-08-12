package br.com.dio.picpayclone.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.service.ITransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends ResouceBase<TransacaoDTO> {

	@Autowired
	private ITransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO, UriComponentsBuilder uriBuilder) {
		TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
		return this.responderItemCriadoComURI(transacaoRetornoDTO, uriBuilder, "/transacoes/{codigo}", transacaoRetornoDTO.getCodigo());
	}
	
}
