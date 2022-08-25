package one.digitalinnovation.parking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tab_parking")
public class Parking {

	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(unique = true)
	private String license;
	
	private String ownerName;
	private String state;
	private String model;
	private String color;
	private LocalDate entryDate;
	private LocalTime entryTime;
	private LocalDate exitDate;
	private LocalTime exitTime;
	private Boolean finished;
	private Double bill;
	
	public Parking() {
		
	}


	public Parking(String id,String ownerName, String license, String state, String model, String color, LocalDate entryDate,
			LocalTime entryTime, LocalDate exitDate, LocalTime exitTime, Boolean finished, Double bill) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
		this.entryDate = entryDate;
		this.entryTime = entryTime;
		this.exitDate = exitDate;
		this.exitTime = exitTime;
		this.finished = finished;
		this.bill = bill;
	}

	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public LocalTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}

	public LocalTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalTime exitTime) {
		this.exitTime = exitTime;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	
}
