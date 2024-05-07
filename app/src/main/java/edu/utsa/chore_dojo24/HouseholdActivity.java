package edu.utsa.chore_dojo24;

import android.content.Context;
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

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class HouseholdActivity extends ComponentActivity {
    private AssetManager assets;
    ListView childList;
    ArrayList<String> dynamicChildList;
    ArrayAdapter<String> listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.household);
        assets = getAssets();
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();

        childList = findViewById(R.id.ChildList);
        dynamicChildList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dynamicChildList);
        childList.setAdapter(listAdapter);

        try {
            // Open the file for reading
            InputStream inputStream = getResources().getAssets().open("family.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read the file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by commas to get individual names
                String[] names = line.split(",");

                // Add each name to the dynamicChildList
                for (String name : names) {
                    dynamicChildList.add(name.trim()); // Trim to remove leading/trailing spaces
                }
            }

            // Close the BufferedReader
            bufferedReader.close();

            // Notify the adapter that the data set has changed
            listAdapter.notifyDataSetChanged();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to read from file", Toast.LENGTH_SHORT).show();
        }


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
                Intent intent = new Intent(HouseholdActivity.this, HouseholdActivity.class);
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

        childButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText childNameInput = (EditText) findViewById(R.id.AddChild);
                String name = childNameInput.getText().toString();
                listAdapter.add(name);
                listAdapter.notifyDataSetChanged();
            }
        });
    }




}
