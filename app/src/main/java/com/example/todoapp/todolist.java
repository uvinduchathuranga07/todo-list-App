package com.example.todoapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class todolist extends AppCompatActivity {

    private List<String> taskList;
    private TaskAdapter adapter;

    ImageView Home,account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList, this);
        Home =  findViewById(R.id.todohome);
        account = findViewById(R.id.todoacc);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        EditText editText = findViewById(R.id.editTextText);
        Button addButton = findViewById(R.id.Addnew);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString();
                if (!newTask.isEmpty()) {
                    taskList.add(newTask);
                    adapter.notifyDataSetChanged();
                    editText.setText(""); // Clear the input field after adding the task
                }
            }
        });
        Home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), todolist.class);
                startActivity(intent);
                finish();
            }
        });

        account.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
