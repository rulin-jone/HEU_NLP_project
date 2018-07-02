/**
 * WeiboController
 * 根据前端发来的请求和参数，传递给相应的Service的方法
 * 在这里，前端发送给http://localhost:8080/TestWeibo一个post请求，参数是一个String，也就是关键词
 */
package com.example.mysql.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mysql.service.WeiboService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeiboController {
    @Autowired
    private WeiboService service;

    @PostMapping("TestWeibo")
    public JSONObject getGenderRatio(@RequestBody String keyword) throws IOException, SolrServerException{
        return service.getGenderRatio(keyword);
    }

}
