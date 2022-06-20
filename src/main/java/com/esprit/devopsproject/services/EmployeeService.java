package com.esprit.devopsproject.services;

import com.esprit.devopsproject.dto.EmployeeListResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeListResponse> getAllEmployees();

    EmployeeListResponse getEmployeeByName(String name);
}
