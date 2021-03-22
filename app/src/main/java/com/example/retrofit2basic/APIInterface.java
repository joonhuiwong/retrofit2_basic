package com.example.retrofit2basic;

import com.example.retrofit2basic.model.MultipleResource;
import com.example.retrofit2basic.model.User;
import com.example.retrofit2basic.model.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users")
    Call<User> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
