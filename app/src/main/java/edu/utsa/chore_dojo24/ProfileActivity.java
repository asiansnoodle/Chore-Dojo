package edu.utsa.chore_dojo24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class ProfileActivity extends ComponentActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        setupButtons();
    }

    private void setupButtons() {
        Button profileButton = (Button) findViewById(R.id.Profile);
        Button houseButton = (Button) findViewById(R.id.Household);
        Button marketButton = (Button) findViewById(R.id.Marketplace);
        Button dashButton = (Button) findViewById(R.id.Dashboard);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        houseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HouseholdActivity.class);
                startActivity(intent);
            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ParentMarketplaceActivity.class);
                startActivity(intent);
            }
        });

        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HouseholdActivity.this, DashboardActivity.class);
                //startActivity(intent);
            }
        });

    }

}
