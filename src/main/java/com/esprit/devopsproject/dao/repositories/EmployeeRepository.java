package com.esprit.devopsproject.dao.repositories;

import com.esprit.devopsproject.dao.models.Department;
import com.esprit.devopsproject.dao.models.Employee;
import com.esprit.devopsproject.dto.EmployeeListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM t_employee e WHERE e.name= :name ")
    public EmployeeListResponse findByName(@Param("name") String name);
}
