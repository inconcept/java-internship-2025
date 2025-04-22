package org.example.springdata.persistence.repository;

import org.example.springdata.criteria.EmployeeSearchCriteria;
import org.example.springdata.dto.EmployeeDto;
import org.example.springdata.persistence.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT e.email FROM Employee e")
    Set<String> findAllEmails();

    @Query("""
        SELECT new org.example.springdata.dto.EmployeeDto(
            e.id,
            e.firstName,
            e.lastName,
            e.email,
            c.name
        )
        FROM Employee e
            LEFT JOIN e.company c
        WHERE (:#{#criteria.firstName} IS NULL OR e.firstName LIKE CONCAT('%', :#{#criteria.firstName}, '%'))
            AND (:#{#criteria.lastName} IS NULL OR e.lastName LIKE CONCAT('%', :#{#criteria.lastName}, '%'))
            AND (:#{#criteria.email} IS NULL OR e.email LIKE CONCAT('%', :#{#criteria.email}, '%'))
            AND (:#{#criteria.companyName} IS NULL OR c.name LIKE CONCAT('%', :#{#criteria.companyName}, '%'))
    """)
    Page<EmployeeDto> findAll(EmployeeSearchCriteria criteria, Pageable pageable);
}
