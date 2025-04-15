package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee_project")
@Setter
@Getter
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_project_id_seq")
    @SequenceGenerator(
            name = "employee_project_id_seq",
            sequenceName = "employee_project_id_seq",
            allocationSize = 50
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "started_date")
    private LocalDate startedDate;
}
