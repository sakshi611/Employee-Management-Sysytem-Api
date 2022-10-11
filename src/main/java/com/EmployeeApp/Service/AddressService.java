package com.EmployeeApp.Service;

import java.util.List;

import com.EmployeeApp.Payloads.AddressDto;

public interface AddressService {

	List<AddressDto> getAllAddress();
	AddressDto getAddressById(Integer employeeId,Integer addressId);
	AddressDto createAddress(AddressDto addressDto, Integer employeeId);
	AddressDto updateAddress(AddressDto addressDto, Integer addressId);
	String deleteAddress(Integer addressId,Integer employeeId);
}
