package one.digitalinnovation.parking.controller.dto;

public class PriceDTO {

	private Long id;
	private Long client_id;
	private int vacancies;
	private int oneHour;
	private int twentyFourHour;
	private double oneHourValue;
	private double additionalPerHourValue;
	private double dayValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
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
