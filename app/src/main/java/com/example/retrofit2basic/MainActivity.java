package com.example.retrofit2basic;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit2basic.model.MultipleResource;
import com.example.retrofit2basic.model.User;
import com.example.retrofit2basic.model.UserList;
import com.example.retrofit2basic.model.callback.DoGetListResourcesCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private TextView responseText;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = (TextView) findViewById(R.id.responseText);

        // Get Retrofit Client and use APIInterface
        apiInterface = APIClient.getClient("https://reqres.in").create((APIInterface.class));

        // GET List Resources
        Call<MultipleResource> call = apiInterface.doGetListResources(); // Define Call
        call.enqueue(new DoGetListResourcesCallback(this));

        // Create new User
        User user = new User("morpheus", "leader");
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();
                Toast.makeText(getApplicationContext(), "[1]" + user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });

        // GET List Users
        Call<UserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + "[2] page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "[2] id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         POST name and job Url encoded.
         **/
        Call<User> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
        call3.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();
                Toast.makeText(getApplicationContext(), "[3]" + user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });

    }

    public TextView getResponseText() {
        return responseText;
    }

    public void setResponseText(TextView responseText) {
        this.responseText = responseText;
    }
}