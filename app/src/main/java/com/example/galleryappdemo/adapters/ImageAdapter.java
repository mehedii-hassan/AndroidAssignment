package com.example.galleryappdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galleryappdemo.databinding.ImageRowDesignBinding;
import com.example.galleryappdemo.models.ImageModel;
import com.example.galleryappdemo.ui.FullImageActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<ImageModel> imageList;
    Context context;
    public ImageAdapter(Context context, List<ImageModel> imageList) {
        this.imageList=imageList;
        this.context=context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageRowDesignBinding binding = ImageRowDesignBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
       // int pos = position;
        Picasso.get().load(imageList.get(position).getUrls()
                        .getRegular()).into(holder.binding.ivRowDesign);

        holder.binding.ivRowDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FullImageActivity.class);
                intent.putExtra("image",imageList.get(position).getUrls().getRegular());
                v.getContext().startActivity(intent);

            }
        });


    }

    public void submitNewImageList(List<ImageModel> imageList) {

        this.imageList = imageList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageRowDesignBinding binding;
        public ImageViewHolder(ImageRowDesignBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
}
