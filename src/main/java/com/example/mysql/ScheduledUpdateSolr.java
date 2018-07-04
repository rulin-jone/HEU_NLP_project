/**
 * Solr增量更新定时器管理
 */
package com.example.mysql;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScheduledUpdateSolr{
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(ScheduledUpdateSolr.class);
    @Autowired
    private HttpConnectionManager connManager;

    // 这里定义要发送更新的core的url，其实也可以在配置文件中写然后注入
    private static String url1;
    static{
        // 具体到core即可，其余路径在下面导入方法中已经写好
        url1 = "http://127.0.0.1:8983/solr/core2";
    }

//    @Scheduled(cron = "0 0 0 * * ? ")   // 每天0点更新一次，正式使用是用这一个
    @Scheduled(cron = "* * * * * ?")    // 每天秒更新一次 测试效果；可以查一下cron表达式，能搜到生成工具；或者用该注解的其他方式也可以，具体请百度
    public void sendDeltaImport(){
        this.deltaImport(url1);
    }

    /**
     * 增量更新发送请求，并接受结果
     */
    private void deltaImport(String url){
        // 通过连接池获取客户端，节省了资源
        CloseableHttpClient client = connManager.getHttpClient();
        // 接受返回结果
        CloseableHttpResponse response = null;

        try{
            // 设置地址
            HttpPost post = new HttpPost(String.format("%s/dataimport?command=delta-import&clean=false&commit=true", url));
            // 发送请求
            response = client.execute(post);
            // 接受回传结果
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("===> Solr增量更新成功");
            } else {
                System.out.println("===> Solr增量更新失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
