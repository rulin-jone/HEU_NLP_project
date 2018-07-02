/**
 * 调用THUCTC进行文本分类的Service
 */
package com.example.mysql.service;

import com.alibaba.fastjson.JSONObject;

public interface ClassificationService {
    public JSONObject classify(JSONObject jsonObject);
}
