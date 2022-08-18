package one.digitalinnovation.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.exception.PriceNotFoundException;
import one.digitalinnovation.parking.model.Price;
import one.digitalinnovation.parking.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
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
	public Price create (Price priceCreate) {
		Price price = new Price();
		price.setVacancies(priceCreate.getVacancies());
		price.setOneHourValue(priceCreate.getOneHourValue());
		price.setAdditionalPerHourValue(priceCreate.getAdditionalPerHourValue());
		price.setDayValue(priceCreate.getDayValue());
		
		priceRepository.save(priceCreate);
		return priceCreate;
	}
	
	@Transactional
	public Price update(Long id, Price priceCreate) {
		Price price = findById(id);
		if (price == null) {
			throw new PriceNotFoundException(id);
		}
		price.setVacancies(priceCreate.getVacancies());
		price.setOneHourValue(priceCreate.getOneHourValue());
		price.setAdditionalPerHourValue(priceCreate.getAdditionalPerHourValue());
		price.setDayValue(priceCreate.getDayValue());
		
		priceRepository.save(priceCreate);
		return price;
	}
	
	@Transactional
	public void delete(Long id) {
		findById(id);
		priceRepository.deleteById(id);
	}
	
}
