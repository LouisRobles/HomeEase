package com.example.homeease;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ClientMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_client_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.nav_client_categories) {
                selectedFragment = new ClientCategoriesFragment();
            } else if (itemId == R.id.nav_client_booking) {
                selectedFragment = new ClientBookingFragment();
            } else if (itemId == R.id.nav_client_inbox) {
                selectedFragment = new ClientInboxFragment();
            } else if (itemId == R.id.nav_client_profile) {
                selectedFragment = new ClientProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}