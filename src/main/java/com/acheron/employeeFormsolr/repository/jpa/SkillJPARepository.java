package com.acheron.employeeFormsolr.repository.jpa;

import com.acheron.employeeFormsolr.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillJPARepository extends JpaRepository<Skill, Integer> {

}
