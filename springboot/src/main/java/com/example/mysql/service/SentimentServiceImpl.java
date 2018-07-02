package com.example.mysql.service;

import com.alibaba.fastjson.JSONObject;
import com.hankcs.hanlp.classification.classifiers.IClassifier;
import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;
import com.hankcs.hanlp.corpus.io.IOUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SentimentServiceImpl implements SentimentService{

    private String CORPUS_FOLDER = "E:\\code\\mysql\\src\\main\\resources\\ChnSentiCorp情感分析酒店评论";
    private String MODEL_PATH = "E:\\code\\mysql\\src\\main\\resources\\ChnSentiCorp情感分析酒店评论SentiAnalyze-model.ser";

    private JSONObject result = new JSONObject();

    public JSONObject analyze(JSONObject jsonObject) throws IOException {

        String text = jsonObject.getString("text");

        NaiveBayesModel model = (NaiveBayesModel) IOUtil.readObjectFrom(MODEL_PATH);
        if(model != null)
        {
            IClassifier classifer = new NaiveBayesClassifier(model);
            result.put("Sentiment", classifer.classify(text));
        }
        else {
            File corpusFolder = new File(CORPUS_FOLDER);
            if (!corpusFolder.exists() || !corpusFolder.isDirectory()) {
                System.err.println("没有文本分类语料，请阅读IClassifier.train(java.lang.String)中定义的语料格式、准备语料");
                System.exit(1);
            }
            IClassifier classifier = new NaiveBayesClassifier();
            classifier.train(CORPUS_FOLDER);
            model = (NaiveBayesModel) classifier.getModel();
            IOUtil.saveObjectTo(model, MODEL_PATH);
            result.put("Sentiment", classifier.classify(text));
        }

        return result;
    }
}
