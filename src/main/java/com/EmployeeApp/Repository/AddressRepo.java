package com.EmployeeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeApp.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
