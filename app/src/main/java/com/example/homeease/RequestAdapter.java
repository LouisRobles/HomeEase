package com.example.homeease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    private List<ClientRequest> requestList;

    public RequestAdapter(List<ClientRequest> requestList) {
        this.requestList = requestList;
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
        ClientRequest request = requestList.get(position);
        holder.userName.setText(request.name);
        holder.userLocation.setText(request.location);
        holder.userPhone.setText(request.phone);
        holder.categoryText.setText(request.category);
        holder.priceText.setText(request.price);
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userLocation, userPhone, categoryText, priceText;

        ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userLocation = itemView.findViewById(R.id.userLocation);
            userPhone = itemView.findViewById(R.id.userPhone);
            categoryText = itemView.findViewById(R.id.categoryText);
            priceText = itemView.findViewById(R.id.priceText);
        }
    }
}
