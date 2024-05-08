package edu.utsa.chore_dojo24;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.Scanner;

public class RealLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Lets do some chores!", Toast.LENGTH_SHORT).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_real_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupButtons();


    }

    AssetManager assets;


    private void setupButtons() {
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.register_button);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EditText uText = (EditText) findViewById(R.id.inputUser);
                EditText pText = (EditText) findViewById(R.id.inputPassword);
                int id = authenticate(uText.getText().toString(), pText.getText().toString());
                if (id > 0) {
                    Intent intent = new Intent(RealLoginActivity.this, RealConfirmedLoginActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    uText.setText("");
                    pText.setText("");
                    uText.setError("Incorrect username and/or password");
                    pText.setError("Incorrect username and/or password");
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(RealLoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private int authenticate(String name, String password){
        String str = "";
        String[] arr;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");

        try {
            if (assets == null)
                assets = getAssets();
            Scanner scan;
            if(f.exists()) {
                scan = new Scanner(openFileInput(("login.txt")));
            }
            scan = new Scanner(assets.open("login.txt"));
            while(scan.hasNext()) {
                str = scan.nextLine();
                arr = str.split(",");
                if(name.equalsIgnoreCase(arr[1]) && password.equals(arr[2])){
                    authenticated = true;
                    id = Integer.parseInt(arr[0]);
                    break;
                }
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        arr = str.split(",");
        //return name.equalsIgnoreCase(arr[1]) && password.equals(arr[2]);
        return id;
    }

}