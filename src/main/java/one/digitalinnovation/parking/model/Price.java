package one.digitalinnovation.parking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "tab_price")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	private int vacancies;
	private double oneHourValue;
	private double additionalPerHourValue;
	private double dayValue;	
	
	public Price() {
		
	}
	
	public Price(Long id, Client client, int vacancies, int oneHour, int twentyFourHour, double oneHourValue,
			double additionalPerHourValue, double dayValue) {
		super();
		this.id = id;
		this.client = client;
		this.vacancies = vacancies;
		this.oneHourValue = oneHourValue;
		this.additionalPerHourValue = additionalPerHourValue;
		this.dayValue = dayValue;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
