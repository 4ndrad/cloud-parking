package one.digitalinnovation.parking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.repository.ParkingRepository;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Parking> findAll(){
		return parkingRepository.findAll();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Parking findById(String id) {
		return parkingRepository.findById(id).orElseThrow(() ->
			new ParkingNotFoundException(id)
		);
	}

	@Transactional
	public Parking create(Parking parkingCreate) {
		String uuid = getUUID();
		parkingCreate.setId(uuid);
		parkingCreate.setEntryDate(LocalDateTime.now());
		parkingRepository.save(parkingCreate);
		return parkingCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		parkingRepository.deleteById(id);
	}

	@Transactional
	public Parking update(String id, Parking parkingCreate) {
		Parking parking = findById(id);
		if (parking == null) {
			throw new ParkingNotFoundException(id);
		}
		parking.setColor(parkingCreate.getColor());
		parking.setLicense(parkingCreate.getLicense());
		parking.setModel(parkingCreate.getModel());
		parking.setState(parkingCreate.getState());
		parkingRepository.save(parking);
		return parking;
	}

	@Transactional
	public Parking checkout(String id) {
		Parking parking = findById(id);
		if (parking == null) {
			throw new ParkingNotFoundException(id);
		}
		parking.setExitDate(LocalDateTime.now());
		parking.setBill(ParkingCheckOut.getBill(parking));
		parkingRepository.save(parking);
		return parking;
	}
	
}
