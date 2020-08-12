package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.dto.TransacaoDTO;

@Component
public class TransacaoConversor extends ConversorBase<Transacao, TransacaoDTO> {

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public TransacaoDTO converterEntidadeParaDto(Transacao entidade) {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>() {

			@Override
			protected void configure() {}
			
		});
		
		return modelMapper.map(entidade, TransacaoDTO.class);
	}

	@SuppressWarnings("unchecked")
	public Page<TransacaoDTO> converterDtoParaEntidade(Page<Transacao> entidade) {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<Page<Transacao>, Page<TransacaoDTO>>() {

			@Override
			protected void configure() {}
			
		});
		
		return modelMapper.map(entidade, Page.class);
	}

	@Override
	public Transacao converterDtoParaEntidade(TransacaoDTO dto) {
		return new Transacao(
				dto.getCodigo(), 
				usuarioService.consultarEntidade(dto.getOrigem().getLogin()), 
				usuarioService.consultarEntidade(dto.getDestino().getLogin()), 
				dto.getDataHora(), 
				dto.getValor()
			);
	}
	
}
