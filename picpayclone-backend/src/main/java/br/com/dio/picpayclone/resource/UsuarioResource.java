package br.com.dio.picpayclone.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.picpayclone.dto.UsuarioDTO;
import br.com.dio.picpayclone.service.impl.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResouceBase<UsuarioDTO> {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{login}")
	public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
		UsuarioDTO usuario = usuarioService.consultar(login);
		
		return responderSucessoComItem(usuario);
	}
	
	@GetMapping("/contatos")
	public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
		List<UsuarioDTO> usuarios = usuarioService.listar(login);
		
		return responderListaDeItens(usuarios);
	}
	
	@GetMapping("/{login}/saldo")
	public ResponseEntity<UsuarioDTO> consultarSaldo(@PathVariable String login) {
		UsuarioDTO usuarioDTO = usuarioService.consultar(login);
		
		return responderSucessoComItem(usuarioDTO);
	}
	
}
