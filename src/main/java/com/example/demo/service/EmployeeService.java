package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee save(Employee client);
    public Employee update(Employee client);
    public void delete(Long id);
    public Optional<Employee> findById(Long id);
    public boolean existById(Long id);

}
