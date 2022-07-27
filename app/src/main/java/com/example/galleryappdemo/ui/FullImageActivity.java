package com.example.galleryappdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.galleryappdemo.databinding.ActivityFullImageBinding;
import com.squareup.picasso.Picasso;

public class FullImageActivity extends AppCompatActivity {
    private ActivityFullImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Picasso.get().load(getIntent()
                .getStringExtra("image")).into(binding.myZoomageView);
    }
}