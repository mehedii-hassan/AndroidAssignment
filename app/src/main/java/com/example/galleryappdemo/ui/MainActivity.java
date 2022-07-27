package com.example.galleryappdemo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.example.galleryappdemo.viewmodels.ImageViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<ImageModel> list;
    private int page = 1;
    private ImageAdapter imageAdapter;
    private ProgressDialog progressDialog;
    private GridLayoutManager gridLayoutManager;
    private int pageSize = 30;
    private ImageViewModel imageViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageViewModel = new ViewModelProvider(this)
                .get(ImageViewModel.class);

        list = new ArrayList<>();
        gridLayoutManager = new GridLayoutManager(this, 3);

        imageAdapter = new ImageAdapter();
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(imageAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        imageViewModel.loadData(page);

        imageViewModel.getImageList().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(List<ImageModel> imageModels) {
                list.addAll(imageModels);
                imageAdapter.submitNewImageList(list);
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "" + list.size(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItem = gridLayoutManager.getChildCount();
                int totalItem = gridLayoutManager.getItemCount();
                int firstVisibleItemPos = gridLayoutManager.findFirstVisibleItemPosition();

                if ((visibleItem + firstVisibleItemPos >= totalItem) && firstVisibleItemPos >= 0
                        && totalItem >= pageSize) {
                    int temp = page++;
                    imageViewModel.loadData(temp);
                }
            }
        });
    }
}