package com.example.mhamada.session13;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by M.Hamada on 01/05/2018.
 */

public class Mysingleton {
    private static Context context;
    private static  Mysingleton Instance;
    private RequestQueue requestQueue;
    Mysingleton(Context context){
        this.context=context;
        requestQueue=getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized Mysingleton getInstance(Context context){
        if (Instance==null){
            Instance=new Mysingleton(context);
        }
        return Instance;
    }
    public<T> void addtorequestque(Request<T> request){
        requestQueue.add(request);
    }


}
