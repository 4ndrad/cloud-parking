package one.digitalinnovation.parking.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import one.digitalinnovation.parking.controller.dto.PriceCreateDTO;
import one.digitalinnovation.parking.controller.dto.PriceDTO;
import one.digitalinnovation.parking.model.Price;

@Component
public class PriceMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public PriceDTO toPriceDTO(Price price) {
		return MODEL_MAPPER.map(price, PriceDTO.class);
	}
	
	public List<PriceDTO> toPriceDTOList(List<Price> priceList){
		return priceList.stream().map(this::toPriceDTO).collect(Collectors.toList());
	}
	
	public Price toPrice(PriceDTO dto) {
		return MODEL_MAPPER.map(dto, Price.class);
	}
	
	public Price toPriceCreate(PriceCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Price.class);		
	}
}
