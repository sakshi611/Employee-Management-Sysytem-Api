package com.EmployeeApp.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer address_id;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> posts = new ArrayList<>();
	
}
