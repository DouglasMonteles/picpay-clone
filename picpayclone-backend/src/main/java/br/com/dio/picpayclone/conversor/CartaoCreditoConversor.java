package br.com.dio.picpayclone.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dio.picpayclone.domain.CartaoCredito;
import br.com.dio.picpayclone.domain.Transacao;
import br.com.dio.picpayclone.dto.CartaoCreditoDTO;
import br.com.dio.picpayclone.dto.TransacaoDTO;
import br.com.dio.picpayclone.service.IUsuarioService;
import br.com.dio.picpayclone.utils.CartaoCreditoUtil;

@Component
public class CartaoCreditoConversor extends ConversorBase<CartaoCredito, CartaoCreditoDTO> {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public CartaoCreditoDTO converterEntidadeParaDto(CartaoCredito entidade) {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>() {

			@Override
			protected void configure() {}
			
		});
		
		return modelMapper.map(entidade, CartaoCreditoDTO.class);
	}

	@Override
	public CartaoCredito converterDtoParaEntidade(CartaoCreditoDTO dto) {
		return new CartaoCredito(
				CartaoCreditoUtil.mascara(dto.getNumero()), 
				dto.getBandeira(), 
				dto.getNumeroToken(), 
				usuarioService.consultarEntidade(dto.getUsuario().getLogin())
			);
	}
	
}
