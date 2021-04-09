package com.techspinsolutions.vascoservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(v -> MainActivity.loadFragment(new SubServiceFragment()));
        }
    }
}
