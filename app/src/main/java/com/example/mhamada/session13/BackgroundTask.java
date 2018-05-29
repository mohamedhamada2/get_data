package com.example.mhamada.session13;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by M.Hamada on 01/05/2018.
 */

public class BackgroundTask {
    ArrayList<Contact>arrayList=new ArrayList<>();
    Context context;
    String url="http://192.168.1.3/Recyclerview";
    BackgroundTask(Context context){
        this.context=context;
    }
    public ArrayList<Contact> getArrayList(){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
              int c=0;
              while (c<response.length()){
                  try {
                      JSONObject jsonObject=response.getJSONObject(c);
                      Contact contact=new Contact();
                      contact.setName(jsonObject.getString("Name"));
                      contact.setEmail(jsonObject.getString("Email"));
                      arrayList.add(contact);
                      c++;
                  } catch (JSONException e) {
                      e.printStackTrace();
                  }

              }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"error happen",Toast.LENGTH_LONG).show();
            }
        });
        Mysingleton.getInstance(context).addtorequestque(jsonArrayRequest);
        return arrayList;
    }
}
