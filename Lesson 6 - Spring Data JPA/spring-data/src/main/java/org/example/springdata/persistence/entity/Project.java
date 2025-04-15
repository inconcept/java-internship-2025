package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.springdata.enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Setter
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @SequenceGenerator(
            name = "project_id_seq",
            sequenceName = "project_id_seq",
            allocationSize = 50
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    /*@ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;*/

    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employeeProjects = new ArrayList<>();
}
