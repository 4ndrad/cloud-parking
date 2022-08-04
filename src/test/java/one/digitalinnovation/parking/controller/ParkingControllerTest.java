package one.digitalinnovation.parking.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.container.AbstractContainerBase;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;

//teste vai subir em uma porta aleatoria
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest { // caso queira usar o testConatiner basta extender esse teste para
										// AbstractContainerBase

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUptest() {
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given().header("Authorization", "Basic dXNlcjpkaW9AMTIz").when().get("/parking").then()
				.statusCode(HttpStatus.OK.value());

	}

//	@Test
//	void whenCreateThenCheckIsCreated() {
//		
//		var createDTO = new ParkingCreateDTO();
//		createDTO.setColor("AMARELO");
//		createDTO.setLicense("KHT-5558");
//		createDTO.setModel("BRASILIA");
//		createDTO.setState("SP");
//		
//		RestAssured.given()
//		.auth()
//		.basic("user", "dio@123")
//		.when()
//		.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//		.body(createDTO)
//		.post("/parking")
//		.then()
//		.statusCode(HttpStatus.CREATED.value())
//		.body("license", Matchers.equalTo("KHT-5558"))
//		.body("color", Matchers.equalTo("AMARELO"));
//
//	}

}
