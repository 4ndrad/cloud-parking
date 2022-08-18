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
import one.digitalinnovation.parking.controller.dto.PriceCreateDTO;
import one.digitalinnovation.parking.controller.dto.PriceDTO;
import one.digitalinnovation.parking.controller.mapper.PriceMapper;
import one.digitalinnovation.parking.model.Price;
import one.digitalinnovation.parking.service.PriceService;

@RestController
@RequestMapping("/price")
@Api(tags = "Price Controller")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@Autowired
	private PriceMapper priceMapper;
	
	@GetMapping
	@ApiOperation("Find all price")
	public ResponseEntity<List<PriceDTO>> findAll(){
		List<Price> priceList = priceService.findAll();
		List<PriceDTO> result = priceMapper.toPriceDTOList(priceList);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Find by Id")
	public ResponseEntity<PriceDTO> findById(@PathVariable Long id){
		Price price = priceService.findById(id);
		PriceDTO result = priceMapper.toPriceDTO(price);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(consumes = "application/json")
	@ApiOperation("Create new price")
	public ResponseEntity<PriceDTO> create(@RequestBody @Valid PriceCreateDTO dto){
		var priceCreate = priceMapper.toPriceCreate(dto);
		Price price = priceService.create(priceCreate);
		PriceDTO result = priceMapper.toPriceDTO(price);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Price update")
	public ResponseEntity<PriceDTO> update(@PathVariable Long id,@RequestBody PriceCreateDTO dto){
		var priceCreate = priceMapper.toPriceCreate(dto);
		Price price = priceService.update(id, priceCreate);
		PriceDTO result = priceMapper.toPriceDTO(price);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete by Id")
	public ResponseEntity<PriceDTO> delete (@PathVariable Long id){
		priceService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
