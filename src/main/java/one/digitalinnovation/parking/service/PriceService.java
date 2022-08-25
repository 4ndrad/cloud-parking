package one.digitalinnovation.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.controller.dto.PriceCreateDTO;
import one.digitalinnovation.parking.controller.dto.PriceUpdateDTO;
import one.digitalinnovation.parking.exception.PriceNotFoundException;
import one.digitalinnovation.parking.model.Client;
import one.digitalinnovation.parking.model.Price;
import one.digitalinnovation.parking.repository.ClientRepository;
import one.digitalinnovation.parking.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Price> findAll(){
		return priceRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Price findById(Long id) {
		return priceRepository.findById(id).orElseThrow(() ->
			new PriceNotFoundException(id)
		);
	}
	
	@Transactional
	public Price create (PriceCreateDTO priceCreate) {
		Price price = new Price();
		Client client = clientRepository.findById(priceCreate.getClientId()).get();
		
		price.setClient(client);
		price.setVacancies(priceCreate.getVacancies());
		price.setOneHourValue(priceCreate.getOneHourValue());
		price.setAdditionalPerHourValue(priceCreate.getAdditionalPerHourValue());
		price.setDayValue(priceCreate.getDayValue());
		
		return priceRepository.save(price);
	}
	
	@Transactional
	public Price update(Long id, PriceUpdateDTO priceUpdate) {
		Price price = findById(id);
		if (price == null) {
			throw new PriceNotFoundException(id);
		}
		price.setVacancies(priceUpdate.getVacancies());
		price.setOneHourValue(priceUpdate.getOneHourValue());
		price.setAdditionalPerHourValue(priceUpdate.getAdditionalPerHourValue());
		price.setDayValue(priceUpdate.getDayValue());
		
		return priceRepository.save(price);
	}
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		priceRepository.deleteById(id);
	}
	



	
}
