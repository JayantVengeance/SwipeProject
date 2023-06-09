package com.example.swipeproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("get")
    Call<List<PostPojo>> getposts();
}
