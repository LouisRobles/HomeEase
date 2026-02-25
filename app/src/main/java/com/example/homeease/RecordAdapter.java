package com.example.homeease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private List<Record> recordList;

    public RecordAdapter(List<Record> recordList) {
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record record = recordList.get(position);
        holder.tvStatus.setText(record.getStatus());
        holder.tvDate.setText(record.getDate());
        holder.tvName.setText(record.getName());
        holder.tvAddress.setText(record.getAddress());
        holder.tvPhone.setText(record.getPhone());
        holder.tvService.setText(record.getService());
        holder.tvPrice.setText(record.getPrice());
        holder.ivProfile.setImageResource(record.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    static class RecordViewHolder extends RecyclerView.ViewHolder {
        TextView tvStatus, tvDate, tvName, tvAddress, tvPhone, tvService, tvPrice;
        ImageView ivProfile;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvService = itemView.findViewById(R.id.tv_service);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }
    }
}
