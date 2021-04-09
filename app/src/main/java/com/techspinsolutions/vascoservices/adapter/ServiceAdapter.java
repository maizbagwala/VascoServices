package com.techspinsolutions.vascoservices.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.techspinsolutions.vascoservices.MainActivity;
import com.techspinsolutions.vascoservices.R;
import com.techspinsolutions.vascoservices.fragments.SubServiceFragment;
import com.techspinsolutions.vascoservices.model.Service_list_model;
import com.techspinsolutions.vascoservices.utils.Variables;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.searchViewHolder> {

    Context context;
    ArrayList<Service_list_model> serviceList;

    public ServiceAdapter(Context context, ArrayList<Service_list_model> serviceList) {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public searchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchViewHolder holder, int position) {

        Service_list_model model = serviceList.get(position);
        holder.textView.setText(model.getService_title());
        Glide.with(context).load(Variables.IMG_SERVICE_URL + model.getService_icon()).into(holder.imageView);
        holder.itemView.setOnClickListener(v -> MainActivity.loadFragment(new SubServiceFragment()));

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    class searchViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public searchViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview_service);
            imageView = itemView.findViewById(R.id.imageView_service);
        }
    }
}
