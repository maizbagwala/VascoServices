package com.techspinsolutions.vascoservices.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techspinsolutions.vascoservices.R;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.SlotViewHolder> {

    int lastPosition = -1;

    @NonNull
    @Override
    public SlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slot_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder holder, int position) {


        if (position == lastPosition) {
            holder.time.setTextColor(Color.WHITE);
            holder.ap.setTextColor(Color.WHITE);
            holder.linearLayout.setBackgroundResource(R.drawable.ic_filled_slot);
        } else {
            holder.time.setTextColor(Color.BLACK);
            holder.ap.setTextColor(Color.BLACK);
            holder.linearLayout.setBackgroundResource(R.drawable.ic_unfilled_slot);
        }

        holder.itemView.setOnClickListener(v -> {
            lastPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class SlotViewHolder extends RecyclerView.ViewHolder {

        TextView time, ap;
        LinearLayout linearLayout;

        public SlotViewHolder(@NonNull View iv) {
            super(iv);
            time = iv.findViewById(R.id.time);
            ap = iv.findViewById(R.id.ap);
            linearLayout = iv.findViewById(R.id.ll);
        }
    }
}
