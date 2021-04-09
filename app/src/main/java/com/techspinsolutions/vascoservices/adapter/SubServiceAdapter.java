package com.techspinsolutions.vascoservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.R;

public class SubServiceAdapter extends RecyclerView.Adapter<SubServiceAdapter.searchViewHolder> {

    @NonNull
    @Override
    public searchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_service_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchViewHolder holder, int position) {
        holder.minus.setOnClickListener(v -> {
            if (!holder.qnty.getText().equals("0")) {
                int q = Integer.parseInt(holder.qnty.getText().toString());
                holder.qnty.setText("" + --q);
            }
        });

        holder.plus.setOnClickListener(v -> {
            int q = Integer.parseInt(holder.qnty.getText().toString());
            holder.qnty.setText("" + ++q);
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class searchViewHolder extends RecyclerView.ViewHolder {

        TextView plus, minus, qnty;

        public searchViewHolder(@NonNull View iv) {
            super(iv);
            plus = iv.findViewById(R.id.plus);
            minus = iv.findViewById(R.id.minus);
            qnty = iv.findViewById(R.id.qnty);
        }
    }
}
