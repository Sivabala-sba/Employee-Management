package com.apartment.employee.controller;

import com.apartment.employee.entity.Employee;
import com.apartment.employee.entity.Role;
import com.apartment.employee.repository.EmployeeRepository;
import com.apartment.employee.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    @GetMapping
    public String viewEmployees(@RequestParam(required = false) String name,
                                @RequestParam(required = false) Long roleId,
                                Model model){

        List<Role> roles = roleRepository.findAll();
        List<Employee> employees;

        if(name != null && !name.isEmpty()) {
            employees = employeeRepository.findByFullNameContainingIgnoreCase(name);
        } else if (roleId != null) {
            Optional<Role> role = roleRepository.findById(roleId);
            employees = role.map(employeeRepository::findByRole).orElse(List.of());
        } else {
            employees = employeeRepository.findAll();
        }

        model.addAttribute("roles", roles);
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("roles", roleRepository.findAll());
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        if(employee.getDateOfJoining() == null){
            employee.setDateOfJoining(LocalDate.now());
        }
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + id));
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roleRepository.findAll());
        return "employee_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }

}
