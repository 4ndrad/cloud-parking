
package one.digitalinnovation.parking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tab_client")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clientName;

	@Column(unique = true)
	private String cnpj;

	private String email;

	private String password;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Parking> parking = new ArrayList<>();
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private Price price;

	public Client() {

	}

	public Client(Long id, String clientName, String cnpj, String email, String password) {
		this.id = id;
		this.clientName = clientName;
		this.cnpj = cnpj;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Parking> getParking() {
		return parking;
	}

	public void setParking(List<Parking> parking) {
		this.parking = parking;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
