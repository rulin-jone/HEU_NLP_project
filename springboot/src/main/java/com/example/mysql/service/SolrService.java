/**
 * 最初尝试访问Solr时的Service，也是声明方法
 */
package com.example.mysql.service;


import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

public interface SolrService{
    public SolrDocumentList findByClassid(String classid) throws IOException, SolrServerException;
}
