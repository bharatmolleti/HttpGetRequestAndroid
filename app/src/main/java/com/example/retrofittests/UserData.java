package com.example.retrofittests;

import java.util.HashMap;
import java.util.Map;

public class UserData extends MappableData{

    // caseId=191&uName=191user&name=David&number=876567432&emergencynum=7896541234&address=8/9/8

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
        mapData.put("caseId", caseId);
        mapData.put("uName", uName);
        mapData.put("name", name);
        mapData.put("number", number);
        mapData.put("emergencynum", emergencynum);
        mapData.put("address", address);
    }
}
