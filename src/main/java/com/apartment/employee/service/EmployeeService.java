package com.apartment.employee.service;

import com.apartment.employee.entity.Employee;
import com.apartment.employee.entity.Role;
import com.apartment.employee.repository.EmployeeRepository;
import com.apartment.employee.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByFullNameContainingIgnoreCase(name);
    }

    public List<Employee> getEmployeesByRoleId(Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        return role.map(employeeRepository::findByRole).orElse(List.of());
    }
}
