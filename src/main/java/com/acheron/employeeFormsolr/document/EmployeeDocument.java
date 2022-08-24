package com.acheron.employeeFormsolr.document;

import com.acheron.employeeFormsolr.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SolrDocument(collection = "empData")
public class EmployeeDocument {

    public static final String EMPLOYEE_NAME = "employeeName";
    public static final String DESIGNATION = "designation";
    public static final String SALARY = "salary";

    @Id
    @Field
    private Integer employeeId;
    @Field
    private String employeeName;
    @Field
    private String designation;
    @Field
    private Long phoneNumber;
    @Field
    private String gender;
    @Field
    private Double salary;
    @Field
    private Set<String> skills;

//    public static Builder getBuilder(Integer employeeId, String employeeName,
//                                     String designation, Long phoneNumber, String gender, Double salary){
//        return  new Builder(employeeId,employeeName,designation,phoneNumber,gender,salary);
//    }
//
//
//        public static class Builder{
//        private EmployeeDocument build;
//        private Builder(Integer employeeId,String employeeName,
//                        String designation,Long phoneNumber,String gender,Double salary){
//            build= new EmployeeDocument();
//            build.employeeId=employeeId;
//            build.employeeName=employeeName;
//            build.designation=designation;
//            build.phoneNumber=phoneNumber;
////            build.dateOfJoining=dateOfJoining;
//            build.gender=gender;
//            build.salary=salary;
////            build.skills=skills;
//        }
//        public  EmployeeDocument build(){
//            return build;
//        }
//    }
}
