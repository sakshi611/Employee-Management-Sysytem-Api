package com.EmployeeApp.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeApp.Entity.Address;
import com.EmployeeApp.Entity.Employee;
import com.EmployeeApp.Exception.ResourceNotFoundException;
import com.EmployeeApp.Payloads.AddressDto;
import com.EmployeeApp.Repository.AddressRepo;
import com.EmployeeApp.Repository.EmployeeRepo;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	


	@Override
	public AddressDto getAddressById(Integer employeeId, Integer addressId) {
		
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		int addressId1 = employee.getAddress_id();
		Address address = this.addressRepo.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addressId));
		if(addressId1==addressId) {
			return this.modelMapper.map(address, AddressDto.class);
		}
		return null;
	}

	@Override
	public AddressDto createAddress(AddressDto addressDto, Integer employeeId) {
		this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		Address address = this.modelMapper.map(addressDto, Address.class);

		Address savedAddress = this.addressRepo.save(address);
		return this.modelMapper.map(savedAddress, AddressDto.class);
	}

	@Override
	public AddressDto updateAddress(AddressDto addressDto, Integer addressId) {
		Address address = this.addressRepo.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addressId));
		
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setState(addressDto.getState());
		address.setStreet(addressDto.getStreet());
		
		Address updatedAddress = this.addressRepo.save(address);
		
		return this.modelMapper.map(updatedAddress, AddressDto.class);
	}

	@Override
	public String deleteAddress(Integer addressId, Integer employeeId) {
		Address address = this.addressRepo.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addressId));
		Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		
		if(addressId==employee.getAddress_id()) {
			this.addressRepo.delete(address);
			return "Address deleted!";
		}
		
		return "address Id is not accosiated with given employee Id";
	}

	@Override
	public List<AddressDto> getAllAddress() {
		
		List<Address> allAddresses = this.addressRepo.findAll();
		List<AddressDto> addDto = allAddresses.stream().map((address)->this.modelMapper.map(allAddresses, AddressDto.class)).collect(Collectors.toList());
		return addDto;
	}

}
