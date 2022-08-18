package one.digitalinnovation.parking.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import one.digitalinnovation.parking.controller.dto.ClientCreateDTO;
import one.digitalinnovation.parking.controller.dto.ClientDTO;
import one.digitalinnovation.parking.model.Client;

@Component
public class ClientMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ClientDTO toClientDTO(Client client) {
		return MODEL_MAPPER.map(client, ClientDTO.class);
	}
	
	public List<ClientDTO> toClientDTOList(List<Client> clientList) {
		return clientList.stream().map(this::toClientDTO).collect(Collectors.toList());
	}

	public Client toClient(ClientDTO dto) {
		return MODEL_MAPPER.map(dto, Client.class);
	}

	public Client toClientCreate(ClientCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Client.class);
	}
}
