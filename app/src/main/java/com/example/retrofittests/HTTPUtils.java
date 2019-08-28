package com.example.retrofittests;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HTTPUtils {

    private static final String TAG = HTTPUtils.class.getSimpleName();

    private static RequestQueue requestQueue;

    private static HTTPUtils utils = null;

    private HTTPUtils(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static HTTPUtils getInstance(Context context) {
        if (utils == null) {
            utils = new HTTPUtils(context);
        }
        return utils;
    }

    public static String reduceMapToRequest(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    public void getRequest(String request, Response.Listener listener, Response.ErrorListener errorListener) {
        Log.d(TAG, "request is : " + request);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, request,
                listener, errorListener);

        // Set the tag on the request.
        stringRequest.setTag(TAG);

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }

    public void stopRequests() {
        if (requestQueue != null) {
            requestQueue.cancelAll(TAG);
        }
    }
}
