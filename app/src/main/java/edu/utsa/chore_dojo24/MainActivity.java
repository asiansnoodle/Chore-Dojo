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

//    private AssetManager assets;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.household);
        setContentView(R.layout.dummy_login);
//        assets = getAssets();
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();

        setupButtons();


    }

    private void setupButtons() {
        Button loginButton = (Button) findViewById(R.id.login);
        Button button_register = (Button) findViewById(R.id.register);
//        Button marketButton = (Button) findViewById(R.id.Marketplace);
//        Button dashButton = (Button) findViewById(R.id.Dashboard);
//
//        Button childButton = (Button) findViewById(R.id.ChildButton);
//
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uText = (EditText) findViewById(R.id.usernameInput);
                EditText pText = (EditText) findViewById(R.id.passwordInput);

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        button_register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);


            }
        });

    }
}