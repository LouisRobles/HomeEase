package com.example.homeease;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Worker_Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_worker_request);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_request);

        // Sample data
        List<ClientRequest> list = new ArrayList<>();
        list.add(new ClientRequest(
                "Daisy Flores",
                "Sta Rosario, Hagonoy, Bulacan",
                "09012556373",
                "Electrical",
                "₱1000"
        ));

        list.add(new ClientRequest(
                "Ren Relleja",
                "Malolos, Bulacan",
                "09123456789",
                "Plumbing",
                "₱800"
        ));

        list.add(new ClientRequest(
                "Jolo Robles",
                "Hagonoy, Bulacan",
                "09987654321",
                "Plumbing",
                "₱800"
        ));

        client_request_card_recycler adapter = new client_request_card_recycler(list);
        recyclerView.setAdapter(adapter);

        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_request) {
                // Already on Request page or handle navigation
                return true;
            } else if (itemId == R.id.nav_record) {
                Toast.makeText(this, "Record Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Worker_Request.this, Worker_Record.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_wallet) {
                Toast.makeText(this, "Wallet Clicked", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Worker_Request.this, Wallet.class);
//                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_profile) {
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Worker_Request.this, Profile.class);
//                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}
