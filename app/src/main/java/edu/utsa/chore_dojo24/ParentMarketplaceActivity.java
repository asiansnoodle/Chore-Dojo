package edu.utsa.chore_dojo24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.util.ArrayList;
import java.util.List;

public class ParentMarketplaceActivity extends ComponentActivity {

    ListView task_list_view;
    ArrayList<String> task_list;
    Button btnAddTask;
    Button btnRemoveTask;
    EditText taskInput;
    EditText rewardInput;
    EditText dueDateInput;
    EditText taskRemoveInput;
    ArrayAdapter<String> arrayAdapter;

    String[] taskLine = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_marketplace);

        task_list_view = (ListView) findViewById(R.id.task_list);
        btnAddTask = (Button) findViewById(R.id.btn_add_task);
        btnRemoveTask = (Button) findViewById(R.id.btn_remove_task);
        taskInput = (EditText) findViewById(R.id.task_input);
        rewardInput = (EditText) findViewById(R.id.reward_input);
        dueDateInput = (EditText) findViewById(R.id.due_date_input);
        taskRemoveInput = (EditText) findViewById(R.id.task_remove_input);

        task_list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, task_list);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString();
                String reward = rewardInput.getText().toString();
                String dueDate = dueDateInput.getText().toString();

                String taskFinished = "TASK: " + task + ", " + "REWARD: " +reward + ", " + "DUE: " +dueDate;

                task_list.add(taskFinished);
                task_list_view.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();

                taskInput.setText("");
                rewardInput.setText("");
                dueDateInput.setText("");
            }
        });

        btnRemoveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),(String)taskToRemove, Toast.LENGTH_SHORT).show();
                for (int i=0; i<task_list.size(); i++){
                    String taskToRemove = taskRemoveInput.getText().toString();
                    taskLine = task_list.get(i).split(",");
                    // Toast.makeText(getBaseContext(),(String)taskLine[0], Toast.LENGTH_LONG).show();
                    if (taskLine[0].equals("TASK: " + taskToRemove)){
                        task_list.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        break;
                    }
                    else {
                        Toast.makeText(getBaseContext(), "Task not found", Toast.LENGTH_LONG).show();
                    }
                }
                taskRemoveInput.setText("");
            }
        });

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
                //Intent intent = new Intent(HouseholdActivity.this, ProfileActivity.class);
                // startActivity(intent);
            }
        });

        houseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentMarketplaceActivity.this, HouseholdActivity.class);
                startActivity(intent);
            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentMarketplaceActivity.this, ParentMarketplaceActivity.class);
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
