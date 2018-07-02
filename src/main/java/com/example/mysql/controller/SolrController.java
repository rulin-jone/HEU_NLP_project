/**
 * 查询Solr的Controller
 */
package com.example.mysql.controller;

import com.example.mysql.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class SolrController{


    @Autowired
    private SolrService service;

    @PostMapping("TestVue")
    public SolrDocumentList findByClassid(@RequestBody String classid) throws IOException, SolrServerException{
        return service.findByClassid(classid);
    }
}