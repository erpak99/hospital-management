package sample.hospital.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PatientCreateRequest {

	private Long id;
	
	@NotBlank(message = "Name can not be empty")
	private String name;

	@NotBlank(message = "Surname can not be empty")
	private String surname;
	
	@Email(message = "Wrong e-mail address format")
	private String email;
	
	@Pattern(regexp = "^[0-9]{11}$",message = "Identity number must be 11 digits and all characters must be numbers")
	private String identityNumber;
	
	@NotBlank(message = "Password can not be empty")
	private String password;

	public PatientCreateRequest() {
		super();
	}

	public PatientCreateRequest(Long id, String name, String surname,String email,
								String identityNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
