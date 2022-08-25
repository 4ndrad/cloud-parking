package one.digitalinnovation.parking.controller.dto;

import javax.validation.constraints.NotNull;

public class PriceUpdateDTO {
	
	@NotNull
	private int vacancies;
	
	@NotNull
	private double oneHourValue;
	
	@NotNull
	private double additionalPerHourValue;
	
	@NotNull
	private double dayValue;
	
	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
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
