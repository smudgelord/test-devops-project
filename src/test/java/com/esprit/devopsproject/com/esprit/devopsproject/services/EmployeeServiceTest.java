package com.esprit.devopsproject.com.esprit.devopsproject.services;

import com.esprit.devopsproject.dao.models.Employee;
import com.esprit.devopsproject.dao.repositories.EmployeeRepository;
import com.esprit.devopsproject.dto.EmployeeListResponse;
import com.esprit.devopsproject.services.EmployeeService;
import com.esprit.devopsproject.services.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    private static ArrayList<Employee> mockEmployees = new ArrayList<>();

    static {
        mockEmployees.add(Employee.builder().email("jack@gmail.com").age(23).username("jack").id(0L).build());
        mockEmployees.add(Employee.builder().email("john@gmail.com").age(24).username("john").id(1L).build());
    }

    @Autowired
    EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

    @DisplayName("Test Get All Employees Without Mock")
    @Test
    void testGetAllEmployees() {
        assertEquals(7, employeeService.getAllEmployees().size());
    }

    @BeforeEach
    void setMockOutput() {
        when(employeeRepository.findAll())
                .thenReturn(mockEmployees);
    }

    @DisplayName("Test Get All Employees With Mock")
    @Test
    void testGetAllEmployeesWithMock() {
        assertEquals(mockEmployees.stream().map(e -> EmployeeListResponse.builder().email(e.getEmail())
                .age(e.getAge()).username(e.getUsername())
                .id(e.getId()).build()).collect(Collectors.toList()), employeeServiceImpl.getAllEmployees());
    }


}
