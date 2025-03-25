package org.example.springdata.persistence.repository;

import org.example.springdata.persistence.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

    @Query("""
        SELECT ep
        FROM EmployeeProject ep
        WHERE ep.employee.id = :employeeId
    """)
    List<EmployeeProject> findByEmployeeId(@Param("employeeId") Long employeeId);

    @Query(value = """
        SELECT ep
        FROM employee_project ep
        WHERE ep.employee_id = :employeeId
    """, nativeQuery = true)
    List<EmployeeProject> findByEmployeeIdNative(@Param("employeeId") Long employeeId);
}
