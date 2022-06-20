package com.esprit.devopsproject.controller;

import com.esprit.devopsproject.dao.models.Employee;
import com.esprit.devopsproject.dao.repositories.EmployeeRepository;
import com.esprit.devopsproject.dto.EmployeeListResponse;
import com.esprit.devopsproject.services.EmployeeService;
import com.esprit.devopsproject.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<EmployeeListResponse>> getEmployees(){
        log.info("Getting All Employees Endpoint");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{name}")
    public EmployeeListResponse getEmployeeByName(@PathVariable String name) {

        return employeeRepository.findByName(name);
    }

}
