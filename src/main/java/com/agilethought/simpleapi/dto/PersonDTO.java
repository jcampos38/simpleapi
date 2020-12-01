package com.agilethought.simpleapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	private Integer idPerson;
	
	@Email(message = "Invalid email address")
	@NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@NotNull(message = "Last Name cannot be null")
	private String lastName;
	
	@NotNull(message = "Age cannot be null")
	private Integer age;
	
	@NotNull(message = "Gender cannot be null")
	private Character gender;
	
	private Float weight;
	private Float height;

}
