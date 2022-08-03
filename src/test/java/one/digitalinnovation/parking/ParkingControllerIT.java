package one.digitalinnovation.parking;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;

//teste vai subir em uma porta aleatoria
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerIT {
	
	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	public void setUptest() {
		RestAssured.port = randomPort;
	}
	
//	@Test
//	void whenFindAllThenCheckResult() {
//		RestAssured.given()
//			.when()
//			.get("/parking")
//			.then()
//			.statusCode(HttpStatus.OK.value())
//			.body("license[0]", Matchers.equalTo("DMS-1111"));
//			
//	}
	
	@Test
	void whenCreateThenCheckIsCreated() {
		
		var createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMARELO");
		createDTO.setLicense("KHT-5558");
		createDTO.setModel("BRASILIA");
		createDTO.setState("SP");
		
		RestAssured.given()
		.when()
		.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/parking")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("license", Matchers.equalTo("KHT-5558"))
		.body("color", Matchers.equalTo("AMARELO"));

	}

}
