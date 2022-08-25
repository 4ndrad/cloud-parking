package one.digitalinnovation.parking.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClientUpdateDTO {

	@NotNull
	@NotEmpty
	private String clientName;

	@Pattern(regexp = "^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$")
	@NotNull
	@NotEmpty
	private String cnpj;

	@Pattern(regexp = "^(.+)@(.+)$")
	@NotNull
	@NotEmpty
	private String email;

	@Size(min = 3, max = 50)
	@NotNull
	@NotEmpty
	private String password;

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

}
