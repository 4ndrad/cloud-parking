package one.digitalinnovation.parking.controller.dto;

public class PriceUpdateDTO {
	
	private int vacancies;
	
	private double oneHourValue;
	
	private double additionalPerHourValue;
	
	private double dayValue;
	
	public PriceUpdateDTO() {
		
	}
	
	public PriceUpdateDTO(int vacancies, double oneHourValue, double additionalPerHourValue, double dayValue) {
		this.vacancies = vacancies;
		this.oneHourValue = oneHourValue;
		this.additionalPerHourValue = additionalPerHourValue;
		this.dayValue = dayValue;
	}

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
