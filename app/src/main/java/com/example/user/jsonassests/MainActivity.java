package com.example.user.jsonassests;

import android.app.Activity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reading text file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open(
                    "jsondata.txt")));
            String temp;
            while ((temp = br.readLine()) != null)
               // Log.e("name",":"+temp);
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
            String myjsonstring = sb.toString();


            // Try to parse JSON
            try {
// Creating JSONObject from String
                JSONObject jsonObjMain = new JSONObject(myjsonstring);

// Creating JSONArray from JSONObject
                JSONArray jsonArray = jsonObjMain.getJSONArray("employee");

// JSONArray has four JSONObject
                for (int i = 0; i < jsonArray.length(); i++) {

// Creating JSONObject from JSONArray
                    JSONObject jsonObj = jsonArray.getJSONObject(i);

// Getting data from individual JSONObject
                    int id = jsonObj.getInt("id");
                    String name = jsonObj.getString("name");
                    String city = jsonObj.getString("city");
                    String gender = jsonObj.getString("gender");
                    int age = jsonObj.getInt("id");

                  
                }

            } catch (JSONException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }







        }



    }



}