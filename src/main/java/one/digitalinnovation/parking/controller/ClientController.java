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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parking.controller.dto.ClientCreateDTO;
import one.digitalinnovation.parking.controller.dto.ClientUpdateDTO;
import one.digitalinnovation.parking.model.Client;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.service.ClientService;

@RestController
@RequestMapping("/client")
@Api(tags = "Client Controller")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	@ApiOperation("Find all Customers")
	public ResponseEntity<List<Client>> findAll(){
		List<Client> clientList = clientService.findAll();
		return ResponseEntity.ok(clientList);
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation("Price find by Id")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client client = clientService.findById(id);
		return ResponseEntity.ok(client);
	}

	@PostMapping(consumes = "application/json")
	@ApiOperation("Create new client")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@RequestBody @Valid ClientCreateDTO dto){
		return clientService.create(dto);
	}
		
	@PutMapping("/{id}")
	@ApiOperation("Parking update")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientUpdateDTO dto){
		Client client = clientService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation("Client delete by Id")
	public ResponseEntity<Parking> delete (@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	




}
