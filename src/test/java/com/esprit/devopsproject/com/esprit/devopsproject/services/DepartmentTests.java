package com.esprit.devopsproject.com.esprit.devopsproject.services;

import com.esprit.devopsproject.dto.DepartmentListResponse;
import com.esprit.devopsproject.services.DepartmentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentTests {

    @Autowired
    DepartmentServiceImpl departmentService ;

    @Test
    public void testRetrieveAllDepartments() {
        List<DepartmentListResponse> listDepartments = departmentService.getAllDepartments();
        Assertions.assertEquals(0, listDepartments.size());
    }

    @Test
    public void testGetEmployeesByHRDepartments() {
        DepartmentListResponse department = departmentService.getDepartmentByName("HR");
        Assertions.assertNotEquals(0, department.getEmployees().size());
    }

    @Test
    public void testGetEmployeesByCloudDepartments() {
        DepartmentListResponse department = departmentService.getDepartmentByName("CLOUD");
        Assertions.assertEquals(7, department.getEmployees().size());
    }
}
