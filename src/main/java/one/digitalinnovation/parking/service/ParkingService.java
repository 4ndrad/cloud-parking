package one.digitalinnovation.parking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controller.dto.ParkingUpdateDTO;
import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Client;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.model.ParkingCheckOut;
import one.digitalinnovation.parking.repository.ClientRepository;
import one.digitalinnovation.parking.repository.ParkingRepository;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Parking> findAll(){
		return parkingRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Parking findById(String id) {
		return parkingRepository.findById(id).orElseThrow(() ->
			new ParkingNotFoundException(id)
		);
	}

	@Transactional
	public Parking create(ParkingCreateDTO parkingCreate) {
		String uuid = getUUID();
		Parking parking = new Parking();
		Client client = clientRepository.findById(parkingCreate.getClientId()).get();

		parking.setId(uuid);
		parking.setClient(client);
		parking.setOwnerName(parkingCreate.getOwnerName());
		parking.setLicense(parkingCreate.getLicense());
		parking.setState(parkingCreate.getState());
		parking.setModel(parkingCreate.getModel());
		parking.setColor(parkingCreate.getColor());
		parking.setEntryTime(LocalTime.now());
		parking.setEntryDate(LocalDate.now());
		parking.setFinished(false);
		
		return parkingRepository.save(parking);
	}
	
	@Transactional
	public Parking checkout(String id){
		Parking parking = findById(id);
		if (parking == null) {
			throw new ParkingNotFoundException(id);
		}
		parking.setExitTime(LocalTime.now());
		parking.setExitDate(LocalDate.now());
		parking.setFinished(true);
		parking.setBill(ParkingCheckOut.getBill(parking));
		
		return parkingRepository.save(parking);
	}
	
	@Transactional
	public Parking update(String id, ParkingUpdateDTO parkingUpdate){
		Parking parking = findById(id);
		if (parking == null) {
			throw new ParkingNotFoundException(id);
		}
		parking.setColor(parkingUpdate.getColor());
		parking.setLicense(parkingUpdate.getLicense());
		parking.setModel(parkingUpdate.getModel());
		parking.setState(parkingUpdate.getState());
		
		return parkingRepository.save(parking);
	}


	@Transactional
	public void delete(String id){
		findById(id);
		parkingRepository.deleteById(id);
	}



	
}
