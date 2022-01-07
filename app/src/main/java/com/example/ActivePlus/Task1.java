package com.example.ActivePlus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class Task1 extends AppCompatActivity {
    LinearProgressIndicator bar;
    CheckBox check1,check2,check3,check4,check5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        bar= findViewById(R.id.ProgressIdicator);
        check1=findViewById(R.id.CheckBox11);
        check2=findViewById(R.id.CheckBox12);
        check3=findViewById(R.id.CheckBox13);
        check4=findViewById(R.id.CheckBox14);
        check5=findViewById(R.id.CheckBox15);



        check1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  if(check1.isChecked()==false){
                    int w = bar.getProgress() -20;
                    bar.setProgress(w);}
                  else{
                      int w = bar.getProgress() +20;
                      bar.setProgress(w);

                  }


                }
            });
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check2.isChecked()==false){
                    int w = bar.getProgress() -20;
                    bar.setProgress(w);}
                else{
                    int w = bar.getProgress() +20;
                    bar.setProgress(w);

                }


            }
        });
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check3.isChecked()==false){
                    int w = bar.getProgress() - 20;
                    bar.setProgress(w);}
                else{
                    int w = bar.getProgress() +20;
                    bar.setProgress(w);

                }


            }
        });
        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check4.isChecked()==false){
                    int w = bar.getProgress() -20;
                    bar.setProgress(w);}
                else{
                    int w = bar.getProgress() + 20;
                    bar.setProgress(w);

                }


            }
        });
        check5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check5.isChecked()==false){
                    int w = bar.getProgress() -20;
                    bar.setProgress(w);}
                else{
                    int w = bar.getProgress() + 20;
                    bar.setProgress(w);

                }


            }
        });




    }




    public void Progress(){


    }
}