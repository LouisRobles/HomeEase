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

public class WorkerRecordFragmentComplete extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_record_complete, container, false);

        RecyclerView rvRecords = view.findViewById(R.id.rvRecords);
        rvRecords.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Record> records = new ArrayList<>();
        records.add(new Record("Completed", "Feb 2, 2025", "Paulo Delacruz", "San Agustin, Hagonoy, Bulacan", "09386215852", "House Cleaning", "P1000", R.drawable.home_ease_logo));
        records.add(new Record("Completed", "Feb 1, 2025", "Jolo Robles", "San Pedro Hagonoy, Bulacan", "09123556373", "Gardening", "P900", R.drawable.home_ease_logo));
        records.add(new Record("Completed", "Jan 30, 2025", "Santi Go", "San Sebastian, Hagonoy, Bulacan", "09123456780", "Electrical", "P1200", R.drawable.home_ease_logo));
        records.add(new Record("Completed", "Jan 28, 2025", "Rico Yan", "Poblacion, Hagonoy, Bulacan", "09123456781", "Plumbing", "P800", R.drawable.home_ease_logo));
        records.add(new Record("Completed", "Jan 25, 2025", "Bea Alonzo", "San Nicolas, Hagonoy, Bulacan", "09123456782", "Construction", "P2000", R.drawable.home_ease_logo));

        RecordAdapter adapter = new RecordAdapter(records);
        rvRecords.setAdapter(adapter);

        Button btnOngoing = view.findViewById(R.id.btn_ongoing);
        Button btnCancelled = view.findViewById(R.id.btn_cancelled);

        btnOngoing.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new WorkerRecordFragment())
                    .commit();
        });

        btnCancelled.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new WorkerRecordFragmentCancelled())
                    .commit();
        });

        return view;
    }
}
