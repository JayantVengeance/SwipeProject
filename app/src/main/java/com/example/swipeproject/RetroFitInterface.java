package com.example.swipeproject;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetroFitInterface {
    @FormUrlEncoded
    @POST("add")
    Call<DataModal> createPost(
            @Field("product_name") String productName,
            @Field("product_type") String productType,
            @Field("price") String price,
            @Field("tax") String tax,
            @Field("files[]") String imageUrl
    );
}
