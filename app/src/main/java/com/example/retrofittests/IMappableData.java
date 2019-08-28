package com.example.retrofittests;

import java.util.Map;

public interface IMappableData {
    Map<String, String> toMap();
    String getQueryParam();
    String getRequestParams();
}
