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

	private int vagas;
	private int oneHour;
	private int twentyFourHour;
	private double oneHourValue;
	private double additionalPerHourValue;
	private double dayValue;	
	
	public Price() {
		
	}
	
	public Price(Long id, Client client, int vagas, int oneHour, int twentyFourHour, double oneHourValue,
			double additionalPerHourValue, double dayValue) {
		super();
		this.id = id;
		this.client = client;
		this.vagas = vagas;
		this.oneHour = oneHour;
		this.twentyFourHour = twentyFourHour;
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
