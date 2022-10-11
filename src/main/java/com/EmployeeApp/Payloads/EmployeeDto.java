package com.EmployeeApp.Payloads;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {

	@NotEmpty
	@Size(min = 2, max = 30, message ="Name length should be minimum 2 characters and maximum 30 characters.")
	private String firstname;
	
	@Size(min = 2, max = 30, message ="Last Name length should be minimum 2 characters and maximum 30 characters.")
	private String lastname;
	
	 @NotNull
	 @Pattern(
	      regexp = "(^([+]\\d{2}([ ])?)?\\d{10}$)",
	      message = "Number should be in format: {+91 1234567890, +911234567890, 1234567890}")
	private String cell_phone;
	
	
	private String address_id;
}
