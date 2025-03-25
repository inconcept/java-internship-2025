package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.springdata.enums.ProjectStatus;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
@Setter
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<EmployeeProject> projects;
}
