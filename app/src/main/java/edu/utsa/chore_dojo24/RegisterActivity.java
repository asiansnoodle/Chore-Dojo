package edu.utsa.chore_dojo24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.ComponentActivity;

public class RegisterActivity extends ComponentActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        //Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT);
        setupButtons();
    }

    private void setupButtons() {
        Button submit_btn = (Button) findViewById(R.id.submit_register);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });



    }

}
