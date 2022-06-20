package com.esprit.devopsproject.dto;

import com.esprit.devopsproject.dao.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeListResponse {

    private Long id;
    private String username;
    private String email;
    private Integer age;
}
