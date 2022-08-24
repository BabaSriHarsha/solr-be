package com.acheron.employeeFormsolr.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill {

    @Id
    @Column(name = "skill_id")
    private Integer skillId;
    @Column(name = "skill_name")
    private String skillName;

}
