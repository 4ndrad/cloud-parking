package one.digitalinnovation.parking.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ParkingUpdateDTO {

	@NotNull
	@NotEmpty
	private String ownerName;

	@Pattern(regexp = "^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$")
	@NotNull
	@NotEmpty
	private String license;
	
	@NotNull
	@NotEmpty
	private String state;
	
	@NotNull
	@NotEmpty
	private String model;
	
	@NotNull
	@NotEmpty
	private String color;

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
