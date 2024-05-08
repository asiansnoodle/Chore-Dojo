package edu.utsa.chore_dojo24;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RegisterActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setupButtons();
        }
    private void setupButtons(){
        Button button1 = (Button) findViewById(R.id.submitRegister);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                int id = -1;
                EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
                EditText passInput = (EditText) findViewById(R.id.register_passwordInput);
                EditText nameInput = (EditText) findViewById(R.id.register_nameInput2);
                EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
                if(validateAccountInfo()){
                  id =  createLogin();
                  if(id > 0){
                      createAccount(id);
                  }
                  finish();
                   // Toast.makeText(getBaseContext(),"All boxes have inputs!", Toast.LENGTH_SHORT).show();
                }
                else{
                    unameInput.setText("");
                    passInput.setText("");
                    nameInput.setText("");
                    emailInput.setText("");
                    unameInput.setError("One or more inputs are empty!");
                    passInput.setError("One or more inputs are empty!");
                    emailInput.setError("One or more inputs are empty!");
                    nameInput.setError("One or more inputs are empty!");

                }
             }
         });
        }
    private boolean validateAccountInfo(){
        EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
        EditText passInput = (EditText) findViewById(R.id.register_passwordInput);
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput2);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);

        if(!unameInput.getText().toString().isEmpty() && !passInput.getText().toString().isEmpty() && !nameInput.getText().toString().isEmpty() && !emailInput.getText().toString().isEmpty()){
            return true;
        }
        return false;
    }
    private int createLogin(){
        EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
        EditText passInput = (EditText) findViewById(R.id.register_passwordInput);
        String username = unameInput.getText().toString();
        String password = unameInput.getText().toString();

//        getFilesDir().getAbsolutePath();
//        openFileInput("");
//        openFileOutput("",MODE_APPEND);

        File f = new File(getFilesDir().getAbsolutePath() + "/login.txt");
        Scanner scan;
        int id = -1;
        String str = null;
        String[] arr;
        if(!f.exists()){
            id = 1;
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("login.txt", MODE_PRIVATE));
                w.write(id + "," + username + "," + password);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        else{
            try {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if(str != null) {
                    arr = str.split(",");
                    if(arr.length == 3) {
                        id = Integer.parseInt(arr[0]);
                    }
                    }

                scan.close();

                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("login.txt", MODE_APPEND));
                w.append( "\n" + id + "," + username + "," + password);
                w.flush();

            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }

    private void createAccount(int id){
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput2);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();

//        getFilesDir().getAbsolutePath();
//        openFileInput("");
//        openFileOutput("",MODE_APPEND);

        File f = new File(getFilesDir().getAbsolutePath() + "/accounts.txt");

        if(!f.exists()){
            id = 1;
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_PRIVATE));
                w.write(id + "," + name + "," + email);
                w.flush();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        else{
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_APPEND));
                w.append("\n" + id + "," + name + "," + email);
                w.close();
            }
            catch (IOException e) {
                Toast.makeText(getBaseContext(), "IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

