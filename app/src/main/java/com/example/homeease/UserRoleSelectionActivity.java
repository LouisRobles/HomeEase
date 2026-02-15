package com.example.homeease;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserRoleSelectionActivity extends AppCompatActivity {

    private Button btnClient, btnWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_role_selection);

        btnClient = findViewById(R.id.btn_client);
        btnWorker = findViewById(R.id.btn_worker);

        btnClient.setOnClickListener(v -> {
            navigateToLanding("client");
        });

        btnWorker.setOnClickListener(v -> {
            navigateToLanding("worker");
        });
    }

    private void navigateToLanding(String role) {
        Intent intent = new Intent(UserRoleSelectionActivity.this, Landing.class);
        intent.putExtra("user_role", role);
        startActivity(intent);
    }
}