package com.example.galleryappdemo.network;

import com.example.galleryappdemo.models.ImageModel;
import com.example.galleryappdemo.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PhotoServiceApi {

    @Headers("Authorization: Client-ID "+ Constants.PHOTOS_API_KEY)
    @GET("photos")
    Call<List<ImageModel>> getPhotos(
            @Query("page") int page,
            @Query("per_page") int perPage
    );

}
