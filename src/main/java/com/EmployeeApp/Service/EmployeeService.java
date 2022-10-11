package com.EmployeeApp.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.EmployeeApp.Payloads.EmployeeDto;

public interface EmployeeService {

	Page<EmployeeDto> getAllEmployees(
		      Integer pageNo, Integer pageSize, String sortBy, String keyword);

		EmployeeDto getEmployeeById(Integer id);
	
		EmployeeDto createEmployee(EmployeeDto employeeDto);

		EmployeeDto updateEmployeeById(Integer id, EmployeeDto employeeEntity);

		void  deleteEmployeeById(Integer id);
	
		List<EmployeeDto> getSomePost(Integer pageNumber, Integer pageSize);
}
