package com.example.groceriesapps.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceriesapps.ProductsDetails;
import com.example.groceriesapps.R;
import com.example.groceriesapps.model.RecentlyViewed;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {

    Context context;
    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);
        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.name.setText(recentlyViewedList.get(position).getName());
        holder.description.setText(recentlyViewedList.get(position).getDescription());
        holder.price.setText(recentlyViewedList.get(position).getPrice());
        holder.qty.setText(recentlyViewedList.get(position).getQuantity());
        holder.unit.setText(recentlyViewedList.get(position).getUnit());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductsDetails.class);
                intent.putExtra("name", recentlyViewedList.get(position).getName());
                intent.putExtra("image", recentlyViewedList.get(position).getBigImageUrl());
                intent.putExtra("price", recentlyViewedList.get(position).getPrice());
                intent.putExtra("description", recentlyViewedList.get(position).getDescription());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{

        TextView name, description, price, qty, unit;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description_item);
            price = itemView.findViewById(R.id.price_item);
            qty = itemView.findViewById(R.id.qty_item);
            unit = itemView.findViewById(R.id.unit_item);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }
}
