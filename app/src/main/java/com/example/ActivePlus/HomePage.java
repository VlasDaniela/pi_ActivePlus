package com.example.ActivePlus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class HomePage extends AppCompatActivity {
Button singupButton;
Button singinButton;
TextInputLayout password;
TextInputLayout username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singupButton = (Button) findViewById(R.id.SingUp);
        singinButton = (Button) findViewById(R.id.SingIn);
        password = findViewById(R.id.passwordsi);
        username = findViewById(R.id.usernamesi);



        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomePage.this, Registration.class));
            }


        });


            singinButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                                startActivity(new Intent(HomePage.this, MainAplicationPage.class));
//

                }

            });
        }
    }
