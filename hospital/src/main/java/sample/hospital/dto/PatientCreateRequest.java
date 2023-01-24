package sample.hospital.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PatientCreateRequest {

	private Long id;
	
	@NotBlank(message = "Name can not be empty")
	private String name;

	@NotBlank(message = "Surname can not be empty")
	private String surname;
	
	@Pattern(regexp = "^[0-9]{11}$",message = "Identity number must be 11 digits and all characters must be numbers")
	private String identityNumber;
	
	@NotBlank(message = "Password can not be empty")
	private String password;

	public PatientCreateRequest() {
		super();
	}

	public PatientCreateRequest(Long id, String name, String surname, String identityNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.identityNumber = identityNumber;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
