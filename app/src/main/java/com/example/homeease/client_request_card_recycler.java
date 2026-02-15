package com.example.homeease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class client_request_card_recycler
        extends RecyclerView.Adapter<client_request_card_recycler.ViewHolder> {

    private List<ClientRequest> data;

    public client_request_card_recycler(List<ClientRequest> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_request_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClientRequest item = data.get(position);

        holder.userName.setText(item.name);
        holder.userLocation.setText(item.location);
        holder.userPhone.setText(item.phone);
        holder.categoryText.setText(item.category);
        holder.priceText.setText(item.price);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userLocation, userPhone, categoryText, priceText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            userLocation = itemView.findViewById(R.id.userLocation);
            userPhone = itemView.findViewById(R.id.userPhone);
            categoryText = itemView.findViewById(R.id.categoryText);
            priceText = itemView.findViewById(R.id.priceText);
        }
    }
}
