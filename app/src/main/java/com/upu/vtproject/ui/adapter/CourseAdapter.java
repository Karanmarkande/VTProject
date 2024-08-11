package com.upu.vtproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upu.vtproject.databinding.CourseItemBinding;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    List<String> item;

    public CourseAdapter(Context context, List<String> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseItemBinding binding = CourseItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        String items = item.get(holder.getAdapterPosition());

        holder.binding.tvName.setText(items);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CourseItemBinding binding;
        public ViewHolder(CourseItemBinding binding) {
            super(binding.getRoot());
            this.binding  = binding;
        }
    }
}
