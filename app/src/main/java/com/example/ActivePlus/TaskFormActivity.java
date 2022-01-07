package com.example.ActivePlus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class TaskFormActivity extends AppCompatActivity {
    TextInputLayout taskname,subtask1,subtask2,subtask3,subtask4,subtask5;
    Button SaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);
        SaveTask=findViewById(R.id.SaveTask);
        taskname=findViewById(R.id.TitleTask);
        subtask1=findViewById(R.id.Task1);
        subtask2=findViewById(R.id.Task2);
        subtask3=findViewById(R.id.Task3);
        subtask4=findViewById(R.id.Task4);
        subtask5=findViewById(R.id.Task5);

    }
}