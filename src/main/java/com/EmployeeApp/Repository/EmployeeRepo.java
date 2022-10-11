package com.EmployeeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeApp.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
