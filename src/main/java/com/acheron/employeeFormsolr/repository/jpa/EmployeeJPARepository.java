package com.acheron.employeeFormsolr.repository.jpa;

import com.acheron.employeeFormsolr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {
}
