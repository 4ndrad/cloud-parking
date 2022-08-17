package one.digitalinnovation.parking.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PriceCreateDTO {
	
	@NotNull
	@NotEmpty
	private int vagas;
	
	@NotNull
	@NotEmpty
	private int oneHour;
	
	@NotNull
	@NotEmpty
	private int twentyFourHour;
	
	@NotNull
	@NotEmpty
	private double oneHourValue;
	
	@NotNull
	@NotEmpty
	private double additionalPerHourValue;
	
	@NotNull
	@NotEmpty
	private double dayValue;

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getOneHour() {
		return oneHour;
	}

	public void setOneHour(int oneHour) {
		this.oneHour = oneHour;
	}

	public int getTwentyFourHour() {
		return twentyFourHour;
	}

	public void setTwentyFourHour(int twentyFourHour) {
		this.twentyFourHour = twentyFourHour;
	}

	public double getOneHourValue() {
		return oneHourValue;
	}

	public void setOneHourValue(double oneHourValue) {
		this.oneHourValue = oneHourValue;
	}

	public double getAdditionalPerHourValue() {
		return additionalPerHourValue;
	}

	public void setAdditionalPerHourValue(double additionalPerHourValue) {
		this.additionalPerHourValue = additionalPerHourValue;
	}

	public double getDayValue() {
		return dayValue;
	}

	public void setDayValue(double dayValue) {
		this.dayValue = dayValue;
	}

}
