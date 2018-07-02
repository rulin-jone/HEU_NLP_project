/**
 * SolrService方法的实现类，仅为尝试连接时用的demo
 * 按下面的过程就可以实现查询，具体返回值类型根据需要修改
 */
package com.example.mysql.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SolrServiceImpl implements SolrService {
    // 建立Solr连接
    private SolrClient client = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr").build();
    // Solr查询参数
    private MapSolrParams queryParams;
    // Solr查询响应
    private QueryResponse response;

    public SolrDocumentList findByClassid(String classid) throws IOException, SolrServerException{
        // Map存放Solr查询的参数
        Map<String, String> queryParamMap = new HashMap<String, String>();
        // q:查询条件 格式"xx:xx"     fl:过滤条件 格式"xx,xx,xx"
        queryParamMap.put("q", "classid:" + classid);
        queryParamMap.put("fl", "name,grade");
        // 初始化查询参数
        queryParams = new MapSolrParams(queryParamMap);
        // 进行查询
        response = client.query("core2", queryParams);
        //  得到查询结果
        SolrDocumentList documents = response.getResults();

        return documents;
    }

}
