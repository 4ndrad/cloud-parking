package one.digitalinnovation.parking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parking.controller.dto.ClientCreateDTO;
import one.digitalinnovation.parking.controller.dto.ClientDTO;
import one.digitalinnovation.parking.controller.mapper.ClientMapper;
import one.digitalinnovation.parking.model.Client;
import one.digitalinnovation.parking.service.ClientService;

@RestController
@RequestMapping("/client")
@Api(tags = "Client Controller")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientMapper clientMapper;
	
	@GetMapping
	@ApiOperation("Find all customers")
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> clientList = clientService.findAll();
		List<ClientDTO> result = clientMapper.toClientDTOList(clientList);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Find by Id")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		Client client = clientService.findById(id);
		ClientDTO result = clientMapper.toClientDTO(client);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(consumes = "application/json")
	@ApiOperation("Create new client")
	public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientCreateDTO dto){
		var clientCreate = clientMapper.toClientCreate(dto);
		Client client = clientService.create(clientCreate);
		ClientDTO result = clientMapper.toClientDTO(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Parking update")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id,@RequestBody ClientCreateDTO dto){
		var clientCreate = clientMapper.toClientCreate(dto);
		Client client = clientService.update(id, clientCreate);
		ClientDTO result = clientMapper.toClientDTO(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete by Id")
	public ResponseEntity<ClientDTO> delete (@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
