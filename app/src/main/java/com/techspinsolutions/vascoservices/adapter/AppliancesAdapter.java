package com.techspinsolutions.vascoservices.adapter;

import android.content.Context;
import android.os.Bundle;
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
import com.techspinsolutions.vascoservices.fragments.ServiceFragment;
import com.techspinsolutions.vascoservices.model.Category_list_model;
import com.techspinsolutions.vascoservices.utils.Variables;

import java.util.ArrayList;

public class AppliancesAdapter extends RecyclerView.Adapter<AppliancesAdapter.AppliancesViewHolder> {

    Context context;
    ArrayList<Category_list_model> products;

//    int Images[] = {R.drawable.appliances, R.drawable.a2, R.drawable.a3, R.drawable.a4};
//    String[] text = {"AC Service & Repair", "RO Service & Repair", "Washing Machine Service", "Geyser Service and Repair"};


    public AppliancesAdapter(Context context, ArrayList<Category_list_model> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override

    public AppliancesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appliances, parent, false);
        return new AppliancesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppliancesViewHolder holder, int position) {
        Category_list_model category_list_model = products.get(position);
        Glide.with(context).load(Variables.IMG_CATEGORY_URL + category_list_model.getImage()).placeholder(R.drawable.a2).into(holder.imageView);

        holder.textView.setText(category_list_model.getTitle());
        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cat_id", category_list_model.getId());
        serviceFragment.setArguments(bundle);
        holder.itemView.setOnClickListener(v -> MainActivity.loadFragment(new ServiceFragment()));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class AppliancesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public AppliancesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);


        }
    }
}
