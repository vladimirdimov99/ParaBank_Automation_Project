package com.java_parabank_demo.helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CredentialsAndURLS {

    private static String baseURL;
    private static String registerURL;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String state;
    private static String zipCode;
    private static String phone;
    private static String ssn;
    private static String username;
    private static String password;
    private static String confirmPW;

    public static void CredentialsAndURLS() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:/Users/Vladimir/IdeaProjects/java_parabank_demo/src/config/config.json");
        Object object = jsonparser.parse(reader);
        JSONObject configJSONObj = (JSONObject) object;

        baseURL = configJSONObj.get("baseURL").toString();
        registerURL = configJSONObj.get("registerURL").toString();
        firstName = configJSONObj.get("name").toString();
        lastName = configJSONObj.get("lastName").toString();
        address = configJSONObj.get("address").toString();
        state = configJSONObj.get("state").toString();
        zipCode = configJSONObj.get("zipcode").toString();
        phone = configJSONObj.get("phone").toString();
        ssn = configJSONObj.get("ssn").toString();
        username = configJSONObj.get("username").toString();
        password = configJSONObj.get("password").toString();
        confirmPW = configJSONObj.get("confirmPW").toString();
    }

    public void setBaseURL(String baseURL){this.baseURL = baseURL;}

    public static String getBaseURL(){return baseURL;}

    public void setRegisterURL(String registerURL) {this.registerURL = registerURL;}

    public static String getRegisterURL() {return registerURL;}

    public void setFirstName(String firstName){this.firstName = firstName;}

    public static String getFirstName() {return firstName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public static String getLastName() {
        return lastName;
    }

    public void setAddress(String address){this.address = address;}

    public static String getAddress(){return address;}

    public void setState(String state){this.state = state;}

    public static String getState(){return state;}

    public void setZipCode(String zipCode){this.zipCode = zipCode;}

    public static String getZipCode(){return zipCode;}

    public void setPhone(String phone){this.phone = phone;}

    public static String getPhone(){return phone;}

    public void setSsn(String ssn){this.ssn = ssn;}

    public static String getSsn(){return ssn;}

    public void setUsername(String username) {this.username = username;}

    public String getUsername() {return username;}

    public void setPassword(String password) {this.password = password;}

    public static String getPassword() {return password;}

    public void setConfirmPW(String confirmPW) {this.confirmPW = confirmPW;}

    public static String getConfirmPW() {return confirmPW;}
}
