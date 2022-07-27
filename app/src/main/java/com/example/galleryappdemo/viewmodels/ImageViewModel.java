package com.example.galleryappdemo.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galleryappdemo.models.ImageModel;
import com.example.galleryappdemo.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageViewModel extends ViewModel {
    private MutableLiveData<List<ImageModel>> imageList = new MutableLiveData<>();

    public LiveData<List<ImageModel>> getImageList() {
        return imageList;
    }

    public void setImageList(MutableLiveData<List<ImageModel>> imageList) {
        this.imageList = imageList;
    }

    public void loadData(int page) {
        RetrofitService.getService().getPhotos(page, 30)
                .enqueue(new Callback<List<ImageModel>>() {
                    @Override
                    public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                        if (response.body() != null) {
                            imageList.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ImageModel>> call, Throwable t) {
                        Log.d("TAG", "Error" + t.getLocalizedMessage());

                    }
                });
    }
}
