package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(employee));
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(service.findAll());
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable ("id") Long id){
        service.delete(id);
        ResponseEntity.ok(service.existById(id));
        return ResponseEntity.ok("The employee with the id: "+id +" was successfully deleted");
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Employee> findById(@PathVariable ("id") Long id){
        service.findById(id);
        ResponseEntity.ok(!service.existById(id));
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Employee> editClient(@RequestBody Employee employee)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(employee));
    }
}
