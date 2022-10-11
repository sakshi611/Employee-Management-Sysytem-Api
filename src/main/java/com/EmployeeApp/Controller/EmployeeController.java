package com.EmployeeApp.Controller;

import java.util.List;

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

import com.EmployeeApp.Payloads.ApiResponse;
import com.EmployeeApp.Payloads.EmployeeDto;
import com.EmployeeApp.Service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto createdEmployee = this.employeeService.createEmployee(employeeDto);		
		return new ResponseEntity<EmployeeDto>(createdEmployee, HttpStatus.CREATED); 
		
	}

	@GetMapping("/employees/{employeeId}/")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer employeeId){
		
		EmployeeDto posts = this.employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<EmployeeDto>(posts, HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ApiResponse deletePost(@PathVariable Integer employeeId) {
		
		this.employeeService.deleteEmployeeById(employeeId);
		
		return new ApiResponse("Post is successfully deleted !",true);
	}

	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDto> updatePost(@RequestBody EmployeeDto employeeDto, @PathVariable Integer employeeId){
		
		EmployeeDto updatedPost = this.employeeService.updateEmployeeById(employeeId, employeeDto);
		return new ResponseEntity<EmployeeDto>(updatedPost, HttpStatus.OK);
	}
	
	
	
	
	
	
}
