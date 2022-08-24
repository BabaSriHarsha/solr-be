package com.acheron.employeeFormsolr.repository.solr;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.util.NamedList;
import java.io.IOException;
import java.util.List;

public interface CustomEmployeeDocumentRepository {

    public List<EmployeeDocument> search(String searchTerm);
//    public NamedList<Object> createFacetSearch() throws SolrServerException, IOException;

}
