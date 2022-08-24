package com.acheron.employeeFormsolr.service;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import com.acheron.employeeFormsolr.model.Employee;
import com.acheron.employeeFormsolr.repository.jpa.EmployeeJPARepository;
import com.acheron.employeeFormsolr.repository.solr.EmployeeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeIndexServiceImpl implements EmployeeIndexService,EmployeeService {

    @Resource
    private EmployeeDocumentRepository employeeDocumentRepository;
    @Autowired
    private EmployeeJPARepository jpaRepository;

    @Transactional
    @Override
    public void addToIndex(Employee emp) {
        jpaRepository.save(emp);
    }

    @Override
    public void save(Employee emp) {
        jpaRepository.save(emp);
    }

    @Override
    public List<Employee> findALl() {
        return  jpaRepository.findAll();
    }



//    @Override
//    public List<EmployeeDocument> findAll() {
//        List<EmployeeDocument> list= employeeDocumentRepository.findAll();
//    }
}
