package com.example.swipeproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroFitInterface
{

    @POST("add")
    Call<DataModal> createPost(@Body DataModal dataModal);
}
