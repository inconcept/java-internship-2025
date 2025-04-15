package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
    @SequenceGenerator(
            name = "employee_id_seq",
            sequenceName = "employee_id_seq",
            allocationSize = 50
    )
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;

    /*@ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;*/

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private List<EmployeeProject> projects = new ArrayList<>();

    public void addEmployeeProject(Project project) {
        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setProject(project);
        employeeProject.setEmployee(this);

        projects.add(employeeProject);
        project.getEmployeeProjects().add(employeeProject);
    }
}
