package com.example.retrofittests;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public abstract class MappableData implements IMappableData {

    private static final String TAG = MappableData.class.getSimpleName();

    protected String queryParam;

    Map<String, String> mapData = null;

    abstract void setQueryParam();

    // fill up the key, value pairs in this class into a map.
    abstract void updateMapData();

    @Override
    public Map<String, String> toMap() {
        if (mapData == null) {
            mapData = new HashMap<String, String>();
            updateMapData();
        }
        return mapData;
    }

    @Override
    public String getQueryParam() {
        return queryParam;
    }

    @Override
    public String getRequestParams() {
        String request = null;
        try {
            request =  HTTPUtils.reduceMapToRequest(toMap());
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Error Encoding Request params");
            e.printStackTrace();
        }
        return request;
    }
}
