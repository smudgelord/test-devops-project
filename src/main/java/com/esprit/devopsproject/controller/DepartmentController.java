package com.esprit.devopsproject.controller;

import com.esprit.devopsproject.dto.DepartmentListResponse;
import com.esprit.devopsproject.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {



    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentListResponse>> getDepartments(){
        log.info("Getting All Departments");
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/department/{name}")
    public DepartmentListResponse getEmployeeByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }

}
