package com.esprit.devopsproject.services;

import com.esprit.devopsproject.dto.DepartmentListResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentListResponse> getAllDepartments();

    DepartmentListResponse getDepartmentByName(String name);
}
