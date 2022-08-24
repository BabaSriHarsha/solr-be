package com.acheron.employeeFormsolr.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    private String designation;
    @Column(name = "phone_number")
    private Long phoneNumber;
    private String gender;
    private Double salary;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name= "employee_skill",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;



}


