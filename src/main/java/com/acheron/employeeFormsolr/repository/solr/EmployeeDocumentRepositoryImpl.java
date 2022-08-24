package com.acheron.employeeFormsolr.repository.solr;

import com.acheron.employeeFormsolr.document.EmployeeDocument;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.util.NamedList;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Repository
public class EmployeeDocumentRepositoryImpl implements CustomEmployeeDocumentRepository {

    @Resource
    private SolrTemplate solrTemplate;

    @Resource
    private SolrClient solrClient;

    /**
     * @param searchTerm
     * @return
     */
    @Override
    public List<EmployeeDocument> search(String searchTerm) {
        String remove = searchTerm.replaceAll("//W", " ");
        String[] words = remove.split(" ");
        Criteria criteria = createSearchConditions(words);
        SimpleQuery search = new SimpleQuery(criteria);
        Page results = solrTemplate.queryForPage("empData", search, EmployeeDocument.class);
        return results.getContent();
    }

    /**
     * creating search conditions on the
     * fields that were present in the
     * solr document
     *
     * @param words
     * @return
     */
    private Criteria createSearchConditions(String[] words) {
        Criteria conditions = null;
        for (String word : words) {
            if (conditions == null) {
                conditions = new Criteria(EmployeeDocument.EMPLOYEE_NAME).contains(word)
                        .or(new Criteria(EmployeeDocument.DESIGNATION).contains(word));
            } else {
                conditions = conditions.or(new Criteria(EmployeeDocument.EMPLOYEE_NAME).contains(word))
                        .or(new Criteria(EmployeeDocument.DESIGNATION).contains(word));
            }
        }
        return conditions;
    }


//    public NamedList<Object> createFacetSearch() throws SolrServerException, IOException {
//        SolrQuery query = new SolrQuery();
//        query.setParam("q", "*:*");
//        query.setFacet(true);
//        query.addFacetField("skills", "designation");
//        QueryResponse response =solrClient.query(query);
//        return  response.getResponse();
//    }

}


