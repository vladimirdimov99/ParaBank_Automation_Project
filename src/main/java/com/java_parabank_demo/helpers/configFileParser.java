package com.java_parabank_demo.helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class configFileParser {
    public static String baseURL;
    public static String loginURL;
    public static String registerURL;
    public static String userIdURL;
    public static String email;
    public static String password;
    public static String name;


    public void configCredentialsParsing() throws IOException, ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:/Users/Samuil/Desktop/JQA Parabank/src/main/java/configFile/config.json");
        Object object = jsonparser.parse(reader);
        JSONObject configJsonObj = (JSONObject) object;
        baseURL = (String) configJsonObj.get("baseURL");

    }


    public void baseURLSet(String baseURL) {
        this.baseURL = baseURL;
    }

    public static String baseURLGet() {
        return baseURL;
    }



    @Test
    public void test() throws IOException, ParseException {
        configCredentialsParsing();
        System.out.println(baseURL);

    }
}

