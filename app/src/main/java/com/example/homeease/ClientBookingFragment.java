package com.example.homeease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class ClientBookingFragment extends Fragment {
    private RecyclerView rvBookings;
    private RecordAdapter adapter;
    private List<Record> upcomingList;
    private List<Record> historyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_booking, container, false);

        rvBookings = view.findViewById(R.id.rvBookings);
        rvBookings.setLayoutManager(new LinearLayoutManager(getContext()));

        loadBookingData();

        // Initial display: Upcoming
        adapter = new RecordAdapter(upcomingList);
        rvBookings.setAdapter(adapter);

        TabLayout tabs = view.findViewById(R.id.bookingTabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    adapter = new RecordAdapter(upcomingList);
                } else {
                    adapter = new RecordAdapter(historyList);
                }
                rvBookings.setAdapter(adapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }

    private void loadBookingData() {
        upcomingList = new ArrayList<>();
        upcomingList.add(new Record("Confirmed", "Feb 20, 2025", "Juan Dela Cruz", "San Agustin, Hagonoy", "09123456789", "House Cleaning", "₱500", R.drawable.home_ease_logo));
        upcomingList.add(new Record("Confirmed", "Feb 22, 2025", "Crispin Santos", "Poblacion, Hagonoy", "09987654321", "Electrical Repair", "₱700", R.drawable.home_ease_logo));

        historyList = new ArrayList<>();
        historyList.add(new Record("Completed", "Feb 10, 2025", "Jose Rizal", "San Jose, Hagonoy", "09112233445", "Garden Maintenance", "₱400", R.drawable.home_ease_logo));
        historyList.add(new Record("Completed", "Feb 05, 2025", "Emilio Aguinaldo", "San Nicolas, Hagonoy", "09556677889", "Wall Painting", "₱1500", R.drawable.home_ease_logo));
        historyList.add(new Record("Cancelled", "Jan 28, 2025", "Maria Clara", "Sta Monica, Hagonoy", "09001122334", "Deep Cleaning", "₱0", R.drawable.home_ease_logo));
    }
}
