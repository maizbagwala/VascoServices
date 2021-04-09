package com.techspinsolutions.vascoservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.fragments.SubServiceFragment;

public class SelectedServiceAdapter extends RecyclerView.Adapter<SelectedServiceAdapter.SelectedServiceViewHolder> {

    @NonNull
    @Override
    public SelectedServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelectedServiceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_service_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class SelectedServiceViewHolder extends RecyclerView.ViewHolder {
        public SelectedServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> MainActivity.loadFragment(new SubServiceFragment()));
        }
    }
}
