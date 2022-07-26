package com.example.galleryappdemo.network;

import com.example.galleryappdemo.models.PhotoModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoServiceApi {

    @GET("photos")
    Call<PhotoModel> getCurrentData();

}
