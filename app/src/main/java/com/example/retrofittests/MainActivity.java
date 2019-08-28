package com.example.retrofittests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView textView;
    HTTPUtils utils;

    String testURL = "https://lcdemo.herokuapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        IMappableData data = testUserDataRequest();

        String urlToGet = testURL + "/" + data.getQueryParam() + "?" + data.getRequestParams();

        if (urlToGet != null) {
            utils = HTTPUtils.getInstance(this);
            utils.getRequest(urlToGet, new Response.Listener() {
                @Override
                public void onResponse(Object response) {
                    Log.d(TAG, "Passed with : " + response.toString());
                    textView.setText("OK Response : " + response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "failed with " + error.getMessage());
                    textView.setText("Failed Response : " + error);
                }
            });
        }

    }

    @Override
    protected void onStop () {
        super.onStop();

    }

    private UserData testUserDataRequest() {
        //caseId=191&uName=191user&name=David&number=876567432&emergencynum=7896541234&address=8/9/8
        UserData data = new UserData();
        Random r = new Random();
        int no = r.nextInt(8000 - 65) + 65;
        data.caseId = no + "";
        data.uName = no + "userName";
        data.name = no+"name";
        data.number = no+"1234567";
        data.emergencynum = no + "98765";
        data.address = no + "someadress";
        return data;
    }
}
