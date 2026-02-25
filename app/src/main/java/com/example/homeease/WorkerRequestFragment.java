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
import java.util.ArrayList;
import java.util.List;

public class WorkerRequestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_request, container, false);

        RecyclerView rvRequests = view.findViewById(R.id.rvRequests);
        rvRequests.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ClientRequest> requests = new ArrayList<>();
        requests.add(new ClientRequest("Daisy Flores", "Sto Rosario, Hagonoy, Bulacan", "09012556373", "Electrical", "₱1500"));
        requests.add(new ClientRequest("Ren Gabriel", "Sta Monica, Hagonoy, Bulacan", "09386214232", "Plumbing", "₱700"));
        requests.add(new ClientRequest("Maria Santos", "San Jose, Hagonoy, Bulacan", "09123456789", "Cleaning", "₱500"));
        requests.add(new ClientRequest("John Doe", "San Pedro, Hagonoy, Bulacan", "09987654321", "Gardening", "₱400"));
        requests.add(new ClientRequest("Ana Reyes", "San Agustin, Hagonoy, Bulacan", "09112233445", "Construction", "₱1000"));

        RequestAdapter adapter = new RequestAdapter(requests);
        rvRequests.setAdapter(adapter);

        return view;
    }
}
