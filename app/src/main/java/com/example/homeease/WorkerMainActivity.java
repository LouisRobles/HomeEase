package com.example.homeease;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WorkerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_worker_home) {
                selectedFragment = new WorkerHomeFragment();
            } else if (itemId == R.id.nav_worker_request) {
                selectedFragment = new WorkerRequestFragment();
            } else if (itemId == R.id.nav_worker_record) {
                selectedFragment = new WorkerRecordFragment();
            } else if (itemId == R.id.nav_worker_earning) {
                selectedFragment = new WorkerEarningFragment();
            } else if (itemId == R.id.nav_worker_profile) {
                selectedFragment = new WorkerProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorkerHomeFragment()).commit();
        }
    }
}