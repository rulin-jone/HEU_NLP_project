/**
 * WeiboService的实现类，实现其中定义的方法（先做了第一个）
 * 连接Solr进行查询的思路基本就是：
 *  1.建立SolrClient连接
 *  2.用Map设置查询参数
 *  3.进行查询，接收结果
 *  4.处理结果，将最终结果放在一个json中返回给前端
 */
package com.example.mysql.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.stereotype.Service;

import java.lang.String;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeiboServiceImpl implements WeiboService {
    // 建立连接
    private SolrClient client = new HttpSolrClient.Builder("http://127.0.0.1:8983/solr").build();
    // 声明查询参数和查询响应
    private MapSolrParams queryParams;
    private QueryResponse response;

    @Override
    public JSONObject getGenderRatio(String keyword) throws IOException, SolrServerException{
        // 返回结果用的json
        JSONObject result = new JSONObject();
        int male = 0, female = 0, unknown = 0;
        // 用Map存放查询的参数，q--查询条件，fl--过滤即需要什么内容
        // 这里用*通配符查询微博内容中带有关键词的记录
        Map<String, String> queryParamMap = new HashMap<java.lang.String, java.lang.String>();
        queryParamMap.put("q", "content:*" + keyword + "*");
        queryParamMap.put("fl", "gender");
        // 用刚才的Map初始化查询参数
        queryParams = new MapSolrParams(queryParamMap);
        // 进行查询，根据情况修改Solr的core
        response = client.query("core3", queryParams);
        // 查询返回的结果时SolrDocumentList类型
        SolrDocumentList documents = response.getResults();

        // 处理部分
        // 将其中每一个SolrDoucment进行处理，在这里就是根据返回的性别，对相应计数进行+1
        for( SolrDocument document : documents)
        {
            switch(document.getFieldValue("gender").toString())
            {
                case "male":
                    male ++; break;
                case "female":
                    female ++; break;
                case "unknown":
                    unknown ++; break;
            }

        }
        // 将处理完的结果放入json中返回
        result.put("male", male);
        result.put("female", female);
        result.put("unknown", unknown);

        return result;
    }
// 下面还没写
//    public JSONObject getAreaRatio(String keyword) throws IOException, SolrServerException {
//        JSONObject result = new JSONObject();
//        return result;
//    }
//
//    public JSONObject getAgeRatio(String keyword) throws IOException, SolrServerException {
//        JSONObject result = new JSONObject();
//        return result;
//    }
//
//    public JSONObject getIndustryRatio(String keyword) throws IOException, SolrServerException {
//        JSONObject result = new JSONObject();
//        return result;
//    }
}
