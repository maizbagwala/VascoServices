package com.techspinsolutions.vascoservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.fragments.SelectDateTimeFragment;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AddressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class AddressViewHolder extends RecyclerView.ViewHolder {
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> MainActivity.loadFragment(new SelectDateTimeFragment()));
        }
    }
}
