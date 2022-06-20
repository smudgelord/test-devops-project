package com.esprit.devopsproject.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "t_department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ArrayList<Employee> employees;

    /* ONE TO ONE BIDIRECTIONAL Department<*---1>Employee(Chef) */
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="employeeId")
    private Long deptChefId ;


}
