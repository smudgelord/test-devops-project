package com.esprit.devopsproject.services;

import com.esprit.devopsproject.dao.models.Employee;
import com.esprit.devopsproject.dao.repositories.EmployeeRepository;
import com.esprit.devopsproject.dto.EmployeeListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeListResponse> getAllEmployees() {
        log.info("Getting All Employees From Database");
        return employeeRepository.findAll()
                .stream().map(e -> EmployeeListResponse
                        .builder().email(e.getEmail())
                        .age(e.getAge()).username(e.getUsername())
                        .id(e.getId()).build()).collect(Collectors.toList());
    }

    @Override
    public EmployeeListResponse getEmployeeByName(String name) {
        log.info("Getting Employee by Name From Database");
        return employeeRepository.findByName(name);
    }
}
