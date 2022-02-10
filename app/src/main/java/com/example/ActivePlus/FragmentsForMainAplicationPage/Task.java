package com.example.ActivePlus.FragmentsForMainAplicationPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ActivePlus.R;
import com.example.ActivePlus.RetrofitInterface;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Task#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Task extends Fragment {

    final int x[]= {0};
    String[] v1=new String[5];
    String[] v2=new String[5];
    String[] v3=new String[5];
    String[] v4=new String[5];
    String[] v5=new String[5];
    int operator=0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView listView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Task() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Task newInstance(String param1, String param2) {
        Task fragment = new Task();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:5001";
    CardView TaskCard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

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
        CardView cardView = fragmentview.findViewById(R.id.cardView);
        CardView cardView2 = fragmentview.findViewById(R.id.cardView2);
        CardView cardView3 = fragmentview.findViewById(R.id.cardView3);
        CardView cardView4 = fragmentview.findViewById(R.id.cardView4);
        CardView cardView5 = fragmentview.findViewById(R.id.cardView5);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress(v1);
            }

        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress(v2);
            }

        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress(v3);
            }

        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress(v4);
            }

        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress(v5);
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

        TextView taskname1=fragmentview.findViewById(R.id.taskk);
        TextView taskname2=fragmentview.findViewById(R.id.taskk1);
        TextView taskname3=fragmentview.findViewById(R.id.taskk2);
        TextView taskname4=fragmentview.findViewById(R.id.taskk3);
        TextView taskname5=fragmentview.findViewById(R.id.taskk4);


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

                            //x[0] = x[0] + 1;
                            switch (x[0]){
                                case 0:{ taskname1.setText(task.getText().toString());
                                 // Log.d("Sa ma pis pe el ","Ma pis "+taskname1.getText().toString());
                                    x[0] = x[0] + 1;}
                                break;
                                case 1: {taskname2.setText(task.getText().toString());
                                  //  Log.d("Key of mess","The mess2 " + task.getText().toString());
                                    x[0] = x[0] + 1;}
                                break;
                                case 2:{ taskname3.setText(task.getText().toString());
                                   // Log.d("Key of mess","The mess3 " + task.getText().toString());
                                    x[0] = x[0] + 1;}
                                break;
                                case 3: {taskname4.setText(task.getText().toString());
                                   // Log.d("Key of mess","The mess4 " + task.getText().toString());
                                    x[0] = x[0] + 1;}
                                break;
                                case 4: {taskname5.setText(task.getText().toString());
                                   // Log.d("Key of mess","The mess5 " + task.getText().toString());
                                    x[0] = 0;}
                                break;
                            }

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
    public  void progress(String vector[]){
        View vi = getLayoutInflater().inflate(R.layout.activity_task1, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setView(vi).show();

        Button save = vi.findViewById(R.id.SaveTask);

        CheckBox c1 = vi.findViewById(R.id.CheckBox11);
        CheckBox c2 = vi.findViewById(R.id.CheckBox12);
        CheckBox c3 = vi.findViewById(R.id.CheckBox13);
        CheckBox c4 = vi.findViewById(R.id.CheckBox14);
        CheckBox c5 = vi.findViewById(R.id.CheckBox15);

        LinearProgressIndicator bar=vi.findViewById(R.id.ProgressIdicator);
        TextInputEditText t1=vi.findViewById(R.id.t1);
        TextInputEditText t2=vi.findViewById(R.id.t2);
        TextInputEditText t3=vi.findViewById(R.id.t3);
        TextInputEditText t4=vi.findViewById(R.id.t4);
        TextInputEditText t5=vi.findViewById(R.id.t5);
        int i=-1;
        if(t1.getText()!=null){
            i++;
            vector[i]=t1.getEditableText().toString();
        }
        if(t2.getText()!=null){
            i++;
            vector[i]=t2.getEditableText().toString();
        }
        if(t3.getText()!=null){
            i++;
            vector[i]=t3.getEditableText().toString();
        }
        if(t4.getText()!=null){
            i++;
            vector[i]=t4.getEditableText().toString();
        }
        if(t5.getText()!=null){
            i++;
            vector[i]=t5.getEditableText().toString();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bar.getProgress()==100){
                    Toast.makeText(getActivity() , "Ai terminat!", Toast.LENGTH_SHORT).show();
                } else {
                    if(bar.getProgress()==20){
                        Toast.makeText(getActivity(), "Ai completat 20%", Toast.LENGTH_SHORT).show();
                    }else{
                        if(bar.getProgress()==40){
                            Toast.makeText(getActivity(), "Ai completat 40%", Toast.LENGTH_SHORT).show();
                        }else{
                            if(bar.getProgress()==60){
                                Toast.makeText(getActivity(), "Ai completat 60%", Toast.LENGTH_SHORT).show();
                            }else {
                                if(bar.getProgress()==80){
                                    Toast.makeText(getActivity(), "Ai ccompletat 80%", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getActivity(), "Nu ai inceput task-ul", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
        c2.setClickable(false);
        c3.setClickable(false);
        c4.setClickable(false);
        c5.setClickable(false);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    bar.setProgress(bar.getProgress()+20);
                    c2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(c2.isChecked()){
                                bar.setProgress(bar.getProgress()+20);
                                c3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(c3.isChecked()){
                                            bar.setProgress(bar.getProgress()+20);
                                            c4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if(c4.isChecked()){
                                                        bar.setProgress(bar.getProgress()+20);
                                                        c5.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if(c5.isChecked()){
                                                                    bar.setProgress(bar.getProgress()+20);

                                                                }
                                                                else {
                                                                    bar.setProgress(bar.getProgress()-20);
                                                                }
                                                            }
                                                        });
                                                    }
                                                    else {
                                                        bar.setProgress(bar.getProgress()-20);
                                                        c5.setClickable(false);
                                                    }
                                                }
                                            });
                                        }
                                        else {
                                            bar.setProgress(bar.getProgress()-20);
                                            c4.setClickable(false);
                                            c5.setClickable(false);
                                        }
                                    }
                                });
                            }
                            else {
                                bar.setProgress(bar.getProgress()-20);
                                c3.setClickable(false);
                                c4.setClickable(false);
                                c5.setClickable(false);
                            }
                        }
                    });
                }
                else {
                    bar.setProgress(bar.getProgress()-20);
                    c2.setClickable(false);
                    c3.setClickable(false);
                    c4.setClickable(false);
                    c5.setClickable(false);
                }
            }
        });

       /* c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c2.isChecked()){
                    bar.setProgress(bar.getProgress()+20);

                }
                else {
                    bar.setProgress(bar.getProgress()-20);
                }
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c3.isChecked()){
                    bar.setProgress(bar.getProgress()+20);

                }
                else {
                    bar.setProgress(bar.getProgress()-20);
                }
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c4.isChecked()){
                    bar.setProgress(bar.getProgress()+20);

                }
                else {
                    bar.setProgress(bar.getProgress()-20);
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c5.isChecked()){
                    bar.setProgress(bar.getProgress()+20);

                }
                else {
                    bar.setProgress(bar.getProgress()-20);
                }
            }
        });*/
    }
    public void insertData(String vector[]){
        View vi = getLayoutInflater().inflate(R.layout.activity_task1, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(vi).show();

        TextInputEditText t1=vi.findViewById(R.id.t1);
        TextInputEditText t2=vi.findViewById(R.id.t2);
        TextInputEditText t3=vi.findViewById(R.id.t3);
        TextInputEditText t4=vi.findViewById(R.id.t4);
        TextInputEditText t5=vi.findViewById(R.id.t5);

        t1.setText(vector[0]);
        t2.setText(vector[1]);
        t3.setText(vector[2]);
        t4.setText(vector[3]);
        t5.setText(vector[4]);

    }
}

