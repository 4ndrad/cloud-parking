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

	private String vagas;
	private String oneHour;
	private String twentyFourHour;
	private String oneHourValue;
	private String additionalPerHourValue;
	private String dayValue;
	
	public Price() {
		
	}

	public Price(Long id, String vagas, String oneHour, String twentyFourHour, String oneHourValue,
			String additionalPerHourValue, String dayValue) {
		this.id = id;
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

	public String getVagas() {
		return vagas;
	}

	public void setVagas(String vagas) {
		this.vagas = vagas;
	}

	public String getOneHour() {
		return oneHour;
	}

	public void setOneHour(String oneHour) {
		this.oneHour = oneHour;
	}

	public String getTwentyFourHour() {
		return twentyFourHour;
	}

	public void setTwentyFourHour(String twentyFourHour) {
		this.twentyFourHour = twentyFourHour;
	}

	public String getOneHourValue() {
		return oneHourValue;
	}

	public void setOneHourValue(String oneHourValue) {
		this.oneHourValue = oneHourValue;
	}

	public String getAdditionalPerHourValue() {
		return additionalPerHourValue;
	}

	public void setAdditionalPerHourValue(String additionalPerHourValue) {
		this.additionalPerHourValue = additionalPerHourValue;
	}

	public String getDayValue() {
		return dayValue;
	}

	public void setDayValue(String dayValue) {
		this.dayValue = dayValue;
	}

}
