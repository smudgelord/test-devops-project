package com.esprit.devopsproject.dao.repositories;

import com.esprit.devopsproject.dao.models.Department;
import com.esprit.devopsproject.dto.DepartmentListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM t_department d WHERE d.name= :name ")
    public DepartmentListResponse findByName(@Param("name") String name);
}
