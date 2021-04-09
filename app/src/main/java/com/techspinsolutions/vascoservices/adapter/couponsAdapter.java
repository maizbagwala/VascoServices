package com.techspinsolutions.vascoservices.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.fragments.CartFragment;

public class couponsAdapter extends RecyclerView.Adapter<couponsAdapter.searchViewHolder> {

    @NonNull
    @Override
    public searchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coupons_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class searchViewHolder extends RecyclerView.ViewHolder {
        public searchViewHolder(@NonNull View itemView) {
            super(itemView);
            CartFragment cartFragment = new CartFragment();
            Bundle bundle = new Bundle();
            bundle.putString("coupon_code", "VASCO10");
            cartFragment.setArguments(bundle);
            itemView.setOnClickListener(v -> MainActivity.loadFragment(cartFragment));
        }
    }
}
