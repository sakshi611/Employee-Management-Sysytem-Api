package com.EmployeeApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeApp.Payloads.AddressDto;
import com.EmployeeApp.Payloads.ApiResponse;
import com.EmployeeApp.Payloads.EmployeeDto;
import com.EmployeeApp.Service.AddressService;
import com.EmployeeApp.Service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/")
	public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto employeeDto,@PathVariable Integer employeeId ){
		
		AddressDto createdEmployee = this.addressService.createAddress(employeeDto, employeeId);	
		return new ResponseEntity<AddressDto>(createdEmployee, HttpStatus.CREATED); 
		
	}

	@GetMapping("/employees/{employeeId}/address/{addressId}/")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer employeeId, @PathVariable Integer addressId){
		
		AddressDto posts = this.addressService.getAddressById(employeeId, addressId);
		return new ResponseEntity<AddressDto>(posts, HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{employeeId}/address/{addressId}/")
	public ApiResponse deleteAddress(@PathVariable Integer employeeId, @PathVariable Integer addressId) {
		
		this.addressService.deleteAddress(addressId, employeeId);
		
		return new ApiResponse("Post is successfully deleted !",true);
	}

	@PutMapping("/employees/{employeeId}/address/{addressId}/")
	public ResponseEntity<AddressDto> updatePost(@RequestBody AddressDto addressDto, @PathVariable Integer addressId){
		
		AddressDto updatedPost = this.addressService.updateAddress(addressDto, addressId);
		return new ResponseEntity<AddressDto>(updatedPost, HttpStatus.OK);
	}
}
