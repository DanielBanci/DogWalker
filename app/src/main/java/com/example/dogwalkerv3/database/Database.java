package com.example.dogwalkerv3.database;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dogwalkerv3.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that helps us manage the database.
 * It performs all the operation we need on the data base in this project.
 * @author Daniel
 * @version 1.0
 */
public class Database {
    private Context context;
    private String url;
    private String phpFile;
    private RequestQueue requestQueue;

    public Database(Context context){
        this.context = context;
        this.url = "http://192.168.56.1/dogWalker/";
        this.phpFile = "";
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void insertUser(){
        this.phpFile = "insertUser.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + phpFile,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            System.out.println("\n\nRespond received: " + success + "\n\n");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("\n\nRespond received: " + response/*success*/ + "\n\n");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                System.out.println("\n\nError!!!!!!!!!!!!!\n\n");
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id","3");
                params.put("name","Alexandra2");
                params.put("email","alexandra@gmail.com");
                params.put("password","123456");

                return params;
            }
        };

        this.requestQueue.add(stringRequest);
    }

    public void getUser(String email, String password){
        this.phpFile = "getUser.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + phpFile,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            System.out.println("\n\nRespond received: " + success + "\n\n");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("\n\nRespond received: " + response/*success*/ + "\n\n");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                System.out.println("\n\nError!!!!!!!!!!!!!\n\n");
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                System.out.println("email = " + email);
                System.out.println("password = " + password);
                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };

        this.requestQueue.add(stringRequest);
    }


}
