package com.apartment.employee.repository;

import com.apartment.employee.entity.Employee;
import com.apartment.employee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFullNameContainingIgnoreCase(String fullName);
    List<Employee> findByRole(Role role);
}
