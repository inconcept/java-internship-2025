package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Setter
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_seq")
    @SequenceGenerator(
            name = "company_id_seq",
            sequenceName = "company_id_seq",
            allocationSize = 50)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "foundation_date", nullable = false)
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
    private List<Employee> employees = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setCompany(this);
    }
}
