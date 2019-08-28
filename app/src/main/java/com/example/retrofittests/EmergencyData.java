package com.example.retrofittests;

public class EmergencyData extends MappableData{

    // caseId=12&uName=12user&latitude=12.567893&longitude=89.567292

    public String caseId;

    public String uName;

    public String latitude;

    public String longitude;

    @Override
    void setQueryParam() {
        queryParam = "addemergency";
    }

    @Override
    void updateMapData() {
        mapData.put("caseId", caseId);
        mapData.put("uName", uName);
        mapData.put("latitude", latitude);
        mapData.put("longitude", longitude);
    }
}
