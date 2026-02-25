package com.example.homeease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class WorkerRecordFragmentCancelled extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_record_cancelled, container, false);

        RecyclerView rvRecords = view.findViewById(R.id.rvRecords);
        rvRecords.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Record> records = new ArrayList<>();
        records.add(new Record("Worker Cancelled", "Jan 21, 2025", "Ren Gabriel", "Sta Monica, Hagonoy, Bulacan", "09386214232", "House Cleaning", "P0", R.drawable.home_ease_logo));
        records.add(new Record("Worker Cancelled", "Jan 21, 2025", "Daisy Flores", "Sto Rosario, Hagonoy, Bulacan", "09012556373", "Gardening", "P0", R.drawable.home_ease_logo));

        RecordAdapter adapter = new RecordAdapter(records);
        rvRecords.setAdapter(adapter);

        Button btnOngoing = view.findViewById(R.id.btn_ongoing);
        Button btnCompleted = view.findViewById(R.id.btn_completed);

        btnOngoing.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new WorkerRecordFragment())
                    .commit();
        });

        btnCompleted.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new WorkerRecordFragmentComplete())
                    .commit();
        });

        return view;
    }
}
