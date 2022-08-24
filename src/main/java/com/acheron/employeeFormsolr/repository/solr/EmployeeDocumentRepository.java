package com.acheron.employeeFormsolr.repository.solr;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface EmployeeDocumentRepository extends CustomEmployeeDocumentRepository,SolrCrudRepository<EmployeeDocument, Integer> {

}
