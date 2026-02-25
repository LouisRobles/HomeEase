package com.example.homeease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder> {

    private List<Worker> allWorkers;
    private List<Worker> displayedWorkers;

    public WorkerAdapter(List<Worker> workerList) {
        this.allWorkers = workerList;
        this.displayedWorkers = new ArrayList<>(workerList);
    }

    @NonNull
    @Override
    public WorkerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_worker, parent, false);
        return new WorkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerViewHolder holder, int position) {
        Worker worker = displayedWorkers.get(position);
        holder.tvName.setText(worker.getName());
        holder.tvCategory.setText(worker.getCategory());
        holder.tvRating.setText(String.valueOf(worker.getRating()));
        holder.tvReviews.setText("(" + worker.getReviews() + " reviews)");
        holder.tvPrice.setText(worker.getPrice());
        holder.ivProfile.setImageResource(worker.getImageResource());
    }

    @Override
    public int getItemCount() {
        return displayedWorkers.size();
    }

    public void filter(String category) {
        displayedWorkers.clear();
        if (category.equals("All")) {
            displayedWorkers.addAll(allWorkers);
        } else {
            for (Worker worker : allWorkers) {
                if (worker.getCategory().equalsIgnoreCase(category)) {
                    displayedWorkers.add(worker);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class WorkerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCategory, tvRating, tvReviews, tvPrice;
        ImageView ivProfile;

        public WorkerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvWorkerName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvReviews = itemView.findViewById(R.id.tvReviews);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivProfile = itemView.findViewById(R.id.ivWorkerProfile);
        }
    }
}
