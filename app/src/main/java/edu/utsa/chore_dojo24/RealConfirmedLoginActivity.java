package edu.utsa.chore_dojo24;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RealConfirmedLoginActivity extends AppCompatActivity {


    private Account profileInfo;
    private AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_real_confirmed_login);
        assets = getAssets();
        profileInfo = null;
        setupProfile();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void setupProfile() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        // profileInfo = new Account(id, assets);
        File f = new File(getFilesDir().getAbsolutePath() + "/accounts.txt");
        Scanner scan;
        String str = "";
        String[] arr;

        try {
            if (assets == null)
                assets = getAssets();
            if(f.exists()) {

                scan = new Scanner(openFileInput("accounts.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (Integer.parseInt(arr[0]) == id) {
                        profileInfo = new Account(id, arr[1], arr[2]);
                        break;
                    }
                }
                scan.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        if(profileInfo != null) {

            TextView name = (TextView) findViewById(R.id.tv2);
            TextView email = (TextView) findViewById(R.id.email);
            name.setText(profileInfo.getName());
            email.setText(profileInfo.getEmail());
        }
    }
}