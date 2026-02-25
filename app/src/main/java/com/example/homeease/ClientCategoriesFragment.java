package com.example.homeease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ClientCategoriesFragment extends Fragment {
    private RecyclerView rvWorkers;
    private WorkerAdapter adapter;
    private List<Worker> workerList;

    private View chipAll, chipCleaning, chipElectrical, chipGardening, chipConstruction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_categories, container, false);

        rvWorkers = view.findViewById(R.id.rvWorkers);
        rvWorkers.setLayoutManager(new LinearLayoutManager(getContext()));

        workerList = new ArrayList<>();
        loadWorkerData();

        adapter = new WorkerAdapter(workerList);
        rvWorkers.setAdapter(adapter);

        initFilters(view);

        return view;
    }

    private void initFilters(View view) {
        chipAll = view.findViewById(R.id.chipAll);
        chipCleaning = view.findViewById(R.id.chipCleaning);
        chipElectrical = view.findViewById(R.id.chipElectrical);
        chipGardening = view.findViewById(R.id.chipGardening);
        chipConstruction = view.findViewById(R.id.chipConstruction);

        chipAll.setOnClickListener(v -> {
            adapter.filter("All");
            updateChipStyles(chipAll);
        });

        chipCleaning.setOnClickListener(v -> {
            adapter.filter("Cleaning");
            updateChipStyles(chipCleaning);
        });

        chipElectrical.setOnClickListener(v -> {
            adapter.filter("Electrical");
            updateChipStyles(chipElectrical);
        });

        chipGardening.setOnClickListener(v -> {
            adapter.filter("Gardening");
            updateChipStyles(chipGardening);
        });

        chipConstruction.setOnClickListener(v -> {
            adapter.filter("Construction");
            updateChipStyles(chipConstruction);
        });
    }

    private void updateChipStyles(View selectedChip) {
        // Reset all chips to unselected (except 'All' which is a TextView)
        resetChipStyle(chipAll);
        resetChipStyle(chipCleaning);
        resetChipStyle(chipElectrical);
        resetChipStyle(chipGardening);
        resetChipStyle(chipConstruction);

        // Set selected chip style
        selectedChip.setBackgroundResource(R.drawable.chip_selected_bg);
        if (selectedChip instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) selectedChip;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                if (child instanceof TextView) {
                    ((TextView) child).setTextColor(getResources().getColor(R.color.white));
                }
            }
        } else if (selectedChip instanceof TextView) {
            ((TextView) selectedChip).setTextColor(getResources().getColor(R.color.white));
        }
    }

    private void resetChipStyle(View chip) {
        chip.setBackgroundResource(R.drawable.chip_unselected_bg);
        if (chip instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) chip;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                if (child instanceof TextView) {
                    ((TextView) child).setTextColor(getResources().getColor(R.color.black));
                }
            }
        } else if (chip instanceof TextView) {
            ((TextView) chip).setTextColor(getResources().getColor(R.color.black));
        }
    }

    private void loadWorkerData() {
        // Cleaning Category
        workerList.add(new Worker("Juan Dela Cruz", "Cleaning", 4.9f, 156, 210, "₱500/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Maria Clara", "Cleaning", 4.8f, 98, 145, "₱450/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Pedro Penduko", "Cleaning", 4.7f, 76, 120, "₱480/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Elena Adarna", "Cleaning", 4.9f, 201, 310, "₱550/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Ricardo Dalisay", "Cleaning", 4.6f, 54, 89, "₱400/day", R.drawable.home_ease_logo));

        // Electrical Category
        workerList.add(new Worker("Crispin Santos", "Electrical", 4.8f, 112, 180, "₱700/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Basilio Reyes", "Electrical", 4.9f, 89, 130, "₱750/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Simoun Ibarra", "Electrical", 4.7f, 65, 95, "₱680/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Felipe Salvador", "Electrical", 4.5f, 43, 60, "₱600/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Andres Bonifacio", "Electrical", 5.0f, 25, 40, "₱800/day", R.drawable.home_ease_logo));

        // Gardening Category
        workerList.add(new Worker("Jose Rizal", "Gardening", 4.9f, 187, 250, "₱400/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Antonio Luna", "Gardening", 4.8f, 134, 190, "₱420/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Melchora Aquino", "Gardening", 4.7f, 92, 110, "₱380/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Gregorio del Pilar", "Gardening", 4.6f, 58, 85, "₱350/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Apolinario Mabini", "Gardening", 4.9f, 45, 70, "₱450/day", R.drawable.home_ease_logo));

        // Construction Category
        workerList.add(new Worker("Emilio Aguinaldo", "Construction", 4.7f, 210, 340, "₱800/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Marcelo del Pilar", "Construction", 4.8f, 156, 220, "₱850/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Juan Luna", "Construction", 4.9f, 120, 180, "₱900/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Gabriela Silang", "Construction", 4.6f, 88, 130, "₱750/day", R.drawable.home_ease_logo));
        workerList.add(new Worker("Lapu-Lapu", "Construction", 5.0f, 67, 90, "₱1000/day", R.drawable.home_ease_logo));
    }
}
