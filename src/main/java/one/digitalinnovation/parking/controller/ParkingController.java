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
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controller.dto.ParkingUpdateDTO;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {
	
	@Autowired
	private ParkingService parkingService;
	
	@GetMapping
	@ApiOperation("Find all Parkings")
	public ResponseEntity<List<Parking>> findAll(){
		List<Parking> parkingList = parkingService.findAll();
		return ResponseEntity.ok(parkingList);
	}

	@GetMapping("/{id}")
	@ApiOperation("Price find by Id")
	public ResponseEntity<Parking> findById(@PathVariable String id){
		Parking parking = parkingService.findById(id);
		return ResponseEntity.ok(parking);
	}
	
	@PostMapping(consumes = "application/json")
	@ApiOperation("Create new parking")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Parking create(@RequestBody @Valid ParkingCreateDTO dto){
		return parkingService.create(dto);
	}
	
	@PostMapping("/{id}")
	@ApiOperation("Checkout parking")
	public ResponseEntity<Parking> exit(@PathVariable String id) {
		Parking parking = parkingService.checkout(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(parking);
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Parking update")
	public ResponseEntity<Parking> update(@PathVariable String id, @RequestBody ParkingUpdateDTO dto) {
		Parking parking = parkingService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(parking);
	}
	
	
	@DeleteMapping("/{id}")
	@ApiOperation("Parking delete by Id")
	public ResponseEntity<Parking> delete (@PathVariable String id){
		parkingService.delete(id);
		return ResponseEntity.noContent().build();
	}





}
