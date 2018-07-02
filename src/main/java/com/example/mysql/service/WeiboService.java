/**
 * 查询Solr中存放的微博数据
 * 声明了如下方法（先做了第一个）
 */
package com.example.mysql.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface WeiboService {
    public JSONObject getGenderRatio(String keyword) throws IOException, SolrServerException;     // 饼状图
//    public JSONObject getAreaRatio(String keyword) throws IOException, SolrServerException;       // 地图
//    public JSONObject getAgeRatio(String keyword) throws IOException, SolrServerException;        // 柱形图
//    public JSONObject getIndustryRatio(String keyword) throws IOException, SolrServerException;   // 柱形图
}
