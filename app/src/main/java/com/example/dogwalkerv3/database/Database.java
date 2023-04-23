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
import com.example.dogwalkerv3.users.DogWalker;
import com.example.dogwalkerv3.users.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

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
    private ServerInterface serverInterface;

    public Database(Context context){
        this.context = context;
        this.url = Server.getInstance().getBaseURL();//"http://192.168.56.1/dogWalker/";
        this.phpFile = "";
        this.requestQueue = Volley.newRequestQueue(context);
        serverInterface = Server.getInstance().getRetrofit().create(ServerInterface.class);
    }

    public void insertUser(User user) {
        Call<String> call = serverInterface.insertUser(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                String resp = response.body();
                System.out.println("Aici e: " + resp);
                System.out.println("Aici e message: " + response.message());
                System.out.println("Aici e body: " + response.body());
                System.out.println("Aici e isSuccesfull: " + response.isSuccessful());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!");
            }
        });
    }
    public interface GetUserCallback {
        void onUserReceived(User user);
        void onError(Throwable throwable);
    }
    public void getUser(String email, String password,GetUserCallback callback){
        this.phpFile = "getUser.php";

        Call<String> call = serverInterface.getUser(email, password);
        //Call<String> call = serverInterface.trySomething(email, password);
        User user = new DogWalker();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                String resp = response.body();

                System.out.println("Aici e: " + resp);
                System.out.println("Aici e message: " + response.message());
                System.out.println("Aici e body: " + response.body());
                System.out.println("Aici e isSuccesfull: " + response.isSuccessful());

                try {
                    // Parse the JSON response
                    JSONObject jsonObject = new JSONObject(resp);

                    // Extract the email and password fields
                    String email = jsonObject.getString("email");
                    String password = jsonObject.getString("password");

                    // Create a new user object and set the email and password fields
System.out.println("DAAAAAAAAAAAAA");
                    user.setEmail(email);
                    user.setPassword(password);
                    callback.onUserReceived(user);

                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!");
            }
        });

    }


}
