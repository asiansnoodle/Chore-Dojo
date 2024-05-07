package edu.utsa.chore_dojo24;

import android.content.res.AssetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends ComponentActivity {

    private AssetManager assets;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.household);
        assets = getAssets();
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();



        setupButtons();
    }

    private void setupButtons() {
        Button profileButton = (Button) findViewById(R.id.Profile);
        Button houseButton = (Button) findViewById(R.id.Household);
        Button marketButton = (Button) findViewById(R.id.Marketplace);
        Button dashButton = (Button) findViewById(R.id.Dashboard);

        Button childButton = (Button) findViewById(R.id.ChildButton);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HouseholdActivity.this, ProfileActivity.class);
                // startActivity(intent);
            }
        });

        houseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, HouseholdActivity.class);
                 startActivity(intent);
            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(HouseholdActivity.this, MarketplaceActivity.class);
                //startActivity(intent);
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
