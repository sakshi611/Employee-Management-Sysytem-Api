package com.EmployeeApp.Payloads;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class AddressDto {

private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
}
