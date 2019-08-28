package com.example.retrofittests;

import java.util.HashMap;
import java.util.Map;

public class UserData extends MappableData{

    // caseId=191&uName=191user&name=David&number=876567432&emergencynum=7896541234&address=8/9/8

    private Map<String, String> sampleData = null;

    public String caseId;

    public String uName;

    public String name;

    public String number;

    public String emergencynum;

    public String address;

    void setQueryParam() {
        queryParam = "adduser";
    }

    @Override
    void updateMapData(){
        sampleData.put("caseId", caseId);
        sampleData.put("uName", uName);
        sampleData.put("name", name);
        sampleData.put("number", number);
        sampleData.put("emergencynum", emergencynum);
        sampleData.put("address", address);
    }
}
