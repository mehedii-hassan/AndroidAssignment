package com.example.galleryappdemo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.galleryappdemo.adapters.ImageAdapter;
import com.example.galleryappdemo.databinding.ActivityMainBinding;
import com.example.galleryappdemo.models.ImageModel;
import com.example.galleryappdemo.network.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<ImageModel> list;
    private int page=1;
    private ImageAdapter imageAdapter;
    private ProgressDialog progressDialog;
    private GridLayoutManager gridLayoutManager;
    private int pageSize=30;
    private boolean isLoading;
    private boolean isLastPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        gridLayoutManager = new GridLayoutManager(this,3);

        imageAdapter = new ImageAdapter(this,list);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(imageAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        
        getData();

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItem = gridLayoutManager.getChildCount();
                int totalItem=gridLayoutManager.getItemCount();
                int firstVisibleItemPos=gridLayoutManager.findFirstVisibleItemPosition();

                if(!isLoading && !isLastPage){
                    if((visibleItem+firstVisibleItemPos>=totalItem)&& firstVisibleItemPos>=0
                    && totalItem>=pageSize){
                        page++;
                        getData();
                    }
                }
            }
        });
    }

    private void getData() {
        isLoading =true;
        RetrofitService.getService().getPhotos(page, 30)
                .enqueue(new Callback<List<ImageModel>>() {
                    @Override
                    public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                        if (response.body() != null) {
                            list.addAll(response.body());
                            Log.d("Response","ok");
                            //imageAdapter.submitNewImageList(list);
                            imageAdapter.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "" + list.size(), Toast.LENGTH_LONG).show();

                        }
                        isLoading=false;
                        progressDialog.dismiss();

                        if(list.size()>0){
                            isLastPage = list.size()<pageSize;
                        }else{
                            isLastPage = true;

                        }

                    }

                    @Override
                    public void onFailure(Call<List<ImageModel>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }
}