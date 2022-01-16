package com.example.ActivePlus.FragmentsForMainAplicationPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ActivePlus.R;
import com.example.ActivePlus.RetrofitInterface;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Task extends Fragment  {

    final int x[]= {0};
    ListView listView;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:5001";
    CardView TaskCard;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentview=inflater.inflate(R.layout.fragemnt_task, container, false);
        TaskCard = (CardView) fragmentview.findViewById(R.id.TaskCard);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        TaskCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCreateTaskDialog();
            }
        });

        return  fragmentview;
    }

    private void handleCreateTaskDialog() {
        View view = getLayoutInflater().inflate(R.layout.activity_task_form, null);

        View fragmentview = getLayoutInflater().inflate(R.layout.fragemnt_task,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setView(view).show();

        Button SaveTask = view.findViewById(R.id.SaveTask);
        TextInputEditText task = view.findViewById(R.id.TitleTask);
        TextInputEditText task1 = view.findViewById(R.id.Task1);
        TextInputEditText task2 = view.findViewById(R.id.Task2);
        TextInputEditText task3 =view.findViewById(R.id.Task3);
        TextInputEditText task4 = view.findViewById(R.id.Task4);
        TextInputEditText task5 = view.findViewById(R.id.Task5);

//        TextView taskname1=fragmentview.findViewById(R.id.taskk);
//        TextView taskname2=fragmentview.findViewById(R.id.taskk1);
//        TextView taskname3=fragmentview.findViewById(R.id.taskk2);
//        TextView taskname4=fragmentview.findViewById(R.id.taskk3);
//        TextView taskname5=fragmentview.findViewById(R.id.taskk4);


        SaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();

                map.put("task", task.getText().toString());
                map.put("task1", task1.getText().toString());
                map.put("task2", task2.getText().toString());
                map.put("task3", task3.getText().toString());
                map.put("task4", task4.getText().toString());
                map.put("task5", task5.getText().toString());

                Call<Void> call = retrofitInterface.executeNewTask(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Toast.makeText(getActivity(),
                                    "Task added", Toast.LENGTH_LONG).show();
//                            Log.d("Key of mess","The mess " + task.getText().toString());
//                            //x[0] = x[0] + 1;
//                            switch (x[0]){
//                                case 0:{ taskname1.setText(task.getText().toString());
//                                    Log.d("Key of mess","The mess " + task.getText().toString());
//                                    x[0] = x[0] + 1;}
//                                break;
//                                case 1: {taskname2.setText(task.getText().toString());
//                                    Log.d("Key of mess","The mess2 " + task.getText().toString());
//                                    x[0] = x[0] + 1;}
//                                break;
//                                case 2:{ taskname3.setText(task.getText().toString());
//                                    Log.d("Key of mess","The mess3 " + task.getText().toString());
//                                    x[0] = x[0] + 1;}
//                                break;
//                                case 3: {taskname4.setText(task.getText().toString());
//                                    Log.d("Key of mess","The mess4 " + task.getText().toString());
//                                    x[0] = x[0] + 1;}
//                                break;
//                                case 4: {taskname5.setText(task.getText().toString());
//                                    Log.d("Key of mess","The mess5 " + task.getText().toString());
//                                    x[0] = 0;}
//                                break;
//                                default:
//                                    throw new IllegalStateException("Unexpected value: " + x[0]);
//                            }

                        } else if (response.code() == 400) {
                            Toast.makeText(getActivity(),
                                    "Already existing task", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    }

