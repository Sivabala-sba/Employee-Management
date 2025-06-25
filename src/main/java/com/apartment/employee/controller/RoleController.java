package com.apartment.employee.controller;

import com.apartment.employee.entity.Role;
import com.apartment.employee.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    @GetMapping
    public String viewRoles(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("role", new Role());
        return "role_form";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("role", new Role());
        return "role_form";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute Role role) {
        roleRepository.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid role ID: " + id));
        model.addAttribute("role", role);
        return "role_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return "redirect:/roles";
    }
}
