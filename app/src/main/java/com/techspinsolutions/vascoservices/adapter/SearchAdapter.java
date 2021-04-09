package com.techspinsolutions.vascoservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.searchViewHolder> {

    @NonNull
    @Override
    public searchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class searchViewHolder extends RecyclerView.ViewHolder {
        public searchViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
