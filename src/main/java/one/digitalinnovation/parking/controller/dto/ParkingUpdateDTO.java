package one.digitalinnovation.parking.controller.dto;

import javax.validation.constraints.Pattern;

public class ParkingUpdateDTO {

	private String ownerName;

	@Pattern(regexp = "^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$")
	private String license;

	private String state;

	private String model;
	
	private String color;
	
	public ParkingUpdateDTO() {
		
	}

	public ParkingUpdateDTO(String ownerName, @Pattern(regexp = "^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$") String license,
			String state, String model, String color) {
		this.ownerName = ownerName;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
