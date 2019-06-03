package com.example.mysql.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mysql.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SentimentController {
    @Autowired
    private SentimentService sentimentService;

    @RequestMapping(value = "sentimentAnalysis", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject analyze(@RequestBody JSONObject jsonObject) throws IOException {
        return sentimentService.analyze((jsonObject));
    }
}
