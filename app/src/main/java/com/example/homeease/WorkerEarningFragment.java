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

public class WorkerEarningFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_earning, container, false);

        RecyclerView rvTransactions = view.findViewById(R.id.rvTransactions);
        rvTransactions.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Payment from Maria Santos", "Feb 15, 2025", "+₱500.00", true));
        transactions.add(new Transaction("Withdrawal to GCash", "Feb 14, 2025", "-₱2,000.00", false));
        transactions.add(new Transaction("Payment from John Doe", "Feb 13, 2025", "+₱400.00", true));
        transactions.add(new Transaction("Payment from Daisy Flores", "Feb 12, 2025", "+₱1,500.00", true));
        transactions.add(new Transaction("Withdrawal to Bank", "Feb 10, 2025", "-₱5,000.00", false));

        TransactionAdapter adapter = new TransactionAdapter(transactions);
        rvTransactions.setAdapter(adapter);

        return view;
    }
}
