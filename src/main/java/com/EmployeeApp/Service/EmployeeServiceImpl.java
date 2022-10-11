package com.EmployeeApp.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.EmployeeApp.Entity.Address;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.ResourceNotFoundException;
import com.EmployeeApp.Payloads.AddressDto;
import com.EmployeeApp.Payloads.EmployeeDto;
import com.EmployeeApp.Repository.AddressRepo;
import com.EmployeeApp.Repository.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	
	@Override
	public Page<EmployeeDto> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		Employee employee = this.employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);

		Employee savedemployee = this.employeeRepo.save(employee);
		return this.modelMapper.map(savedemployee, EmployeeDto.class);
		
	}

	@Override
	public EmployeeDto updateEmployeeById(Integer id, EmployeeDto employeeEntity) {
		Employee employee = this.employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		employee.setCell_phone(employeeEntity.getCell_phone());
		employee.setFirstname(employeeEntity.getFirstname());
		employee.setLastname(employeeEntity.getLastname());
		
		Employee updatedEmployee = this.employeeRepo.save(employee);
		
		return this.modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		
		Employee employee = this.employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		this.employeeRepo.delete(employee);

	}

	@Override
	public List<EmployeeDto> getSomePost(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
