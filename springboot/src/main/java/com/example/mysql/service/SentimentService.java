package com.example.mysql.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public interface SentimentService {
    public JSONObject analyze(JSONObject jsonObject) throws IOException;
}
