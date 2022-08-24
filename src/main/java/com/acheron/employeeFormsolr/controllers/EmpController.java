package com.acheron.employeeFormsolr.controllers;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import com.acheron.employeeFormsolr.model.Employee;
import com.acheron.employeeFormsolr.model.Skill;
import com.acheron.employeeFormsolr.repository.jpa.SkillJPARepository;
import com.acheron.employeeFormsolr.repository.solr.EmployeeDocumentRepository;
import com.acheron.employeeFormsolr.service.EmployeeIndexService;
import com.acheron.employeeFormsolr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashSet;
import java.util.*;


@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class EmpController {

    @Autowired
    private  EmployeeIndexService employeeIndexService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillJPARepository jpaRepository;

    @Autowired
    private EmployeeDocumentRepository employeeDocumentRepository;

    /**
     * saving an employee in database as well as solr document
     * @param emp
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<String>addEmployee(@RequestBody Employee emp){
        Employee emp1= new Employee();
        emp1.setEmployeeId(emp.getEmployeeId());
        emp1.setEmployeeName(emp.getEmployeeName());
        emp1.setDesignation(emp.getDesignation());
        emp1.setGender(emp.getGender());
        emp1.setSalary(emp.getSalary());
        emp1.setPhoneNumber(emp.getPhoneNumber());
        emp1.setSkills(emp.getSkills());
        employeeService.save(emp1);
        employeeDocumentRepository.save(createDocument(emp1));
        return ResponseEntity.ok().body("created");
    }

    /***
     * creating an document to save in solr
     * @param employee
     * @return
     */
    public EmployeeDocument createDocument(Employee employee){
        EmployeeDocument document= new EmployeeDocument();
        document.setEmployeeId(employee.getEmployeeId());
        document.setEmployeeName(employee.getEmployeeName());
        document.setDesignation(employee.getDesignation());
        document.setGender(employee.getGender());
        document.setPhoneNumber(employee.getPhoneNumber());
        document.setSalary(employee.getSalary());
        Set<String> skills = new HashSet<String>();
        for (Skill skill:employee.getSkills()) {
            skills.add(skill.getSkillName());
        }
        document.setSkills(skills);
        return document;
    }

    /**
     * controller for using the search term
     * @param searchTerm
     * @return
     */
    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<EmployeeDocument>> search(@PathVariable("searchTerm") String searchTerm){
            List<EmployeeDocument> employeeDocuments = employeeDocumentRepository.search(searchTerm);
            return new ResponseEntity<>(employeeDocuments, HttpStatus.OK);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getALlSkills(){
        List<Skill> skills = jpaRepository.findAll();
        return new ResponseEntity<List<Skill>>(skills, HttpStatus.OK);
    }

    @GetMapping("/get-all-docs")
    public ResponseEntity<Iterable<EmployeeDocument>> renderAllDocuments(){
        Iterable<EmployeeDocument> employeeDocuments = employeeDocumentRepository.findAll();
        List<EmployeeDocument> documents = new ArrayList<>();
        for(EmployeeDocument docs:employeeDocuments){
            documents.add(docs);
        }
    return ResponseEntity.ok().body(documents);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        List<Employee>employees= employeeService.findALl();
        return  ResponseEntity.ok().body(employees);
    }

//    @GetMapping("test")
//    public ResponseEntity<NamedList<Object>> getList() throws SolrServerException, IOException {
//        return ResponseEntity.ok().body(employeeDocumentRepository.createFacetSearch());
//    }

}
