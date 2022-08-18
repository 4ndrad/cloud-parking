package one.digitalinnovation.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.exception.ClientNotFoundException;
import one.digitalinnovation.parking.model.Client;
import one.digitalinnovation.parking.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clientRepository.findById(id).orElseThrow(() ->
			new ClientNotFoundException(id)
		);
	}
	
	@Transactional
	public Client create (Client clientCreate) {
		Client client = new Client();
		client.setClientName(clientCreate.getClientName());
		client.setCnpj(clientCreate.getCnpj());
		client.setEmail(clientCreate.getEmail());
		client.setPassword(client.getPassword());
		
		clientRepository.save(clientCreate);
		return clientCreate;
	}
	
	@Transactional
	public Client update(Long id, Client clientCreate) {
		Client client = findById(id);
		if (client == null) {
			throw new ClientNotFoundException(id);
		}
		client.setClientName(clientCreate.getClientName());
		client.setCnpj(clientCreate.getCnpj());
		client.setEmail(clientCreate.getEmail());
		client.setPassword(client.getPassword());
		
		clientRepository.save(clientCreate);
		return client;
	}
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		clientRepository.deleteById(id);
	}
	
}
