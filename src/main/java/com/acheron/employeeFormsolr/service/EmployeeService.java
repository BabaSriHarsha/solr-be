package com.acheron.employeeFormsolr.service;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import com.acheron.employeeFormsolr.model.Employee;

import java.util.*;

public interface EmployeeService {
    public void save(Employee emp);
    public List<Employee> findALl();
//    public List<EmployeeDocument>findAll();
}
