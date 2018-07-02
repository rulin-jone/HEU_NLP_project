package com.example.mysql.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mysql.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @RequestMapping(value = "textClassification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject classify(@RequestBody JSONObject jsonObject){
        return classificationService.classify(jsonObject);
    }
}
