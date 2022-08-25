package one.digitalinnovation.parking.controller;

import java.util.List;
import java.util.Optional;

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
import one.digitalinnovation.parking.controller.dto.PriceCreateDTO;
import one.digitalinnovation.parking.controller.dto.PriceUpdateDTO;
import one.digitalinnovation.parking.model.Price;
import one.digitalinnovation.parking.service.PriceService;

@RestController
@RequestMapping("/price")
@Api(tags = "Price Controller")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping
	@ApiOperation("Find all Price")
	public ResponseEntity<List<Price>> findAll(){
		List<Price> priceList = priceService.findAll();
		return ResponseEntity.ok(priceList);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Price find by Id")
	public ResponseEntity<Price> getClient(@PathVariable("id") Long id){
		final Optional<Price> price = Optional.of(priceService.findById(id));
		
		if (price.isPresent()) {
			return ResponseEntity.ok(price.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(consumes = "application/json")
	@ApiOperation("Create new price")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Price create(@RequestBody @Valid PriceCreateDTO dto){
		return priceService.create(dto);
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Parking update")
	public ResponseEntity<Price> update(@PathVariable Long id,@RequestBody PriceUpdateDTO dto){
		Price price = priceService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(price);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Price delete by Id")
	public ResponseEntity<Price> delete (@PathVariable Long id){
		priceService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
