package com.example.ActivePlus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:5001";

    Button singupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);


        findViewById(R.id.SingUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSignupDialog();
            }
        });
        findViewById(R.id.SingIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hadleLoginDialog();
            }
        });

        /*findViewById(R.id.SingIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button loginBtn = view.findViewById(R.id.SingIn);
                EditText username = view.findViewById(R.id.usernamesi);
                EditText password = view.findViewById(R.id.passwordsi);

                loginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HashMap<String, String> map = new HashMap<>();

                        map.put("username", username.getText().toString());
                        map.put("password", password.getText().toString());

                        Call<LoginResult> call = retrofitInterface.executeLogin(map);

                        call.enqueue(new Callback<LoginResult>() {
                            @Override
                            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                                if (response.code() == 200) {

                                    LoginResult result = response.body();
                                    Toast.makeText(HomePage.this, "SIGNED IN",
                                            Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(HomePage.this, MainAplicationPage.class));

                                } else if (response.code() == 404) {
                                    Toast.makeText(HomePage.this, "Wrong Credentials",
                                            Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginResult> call, Throwable t) {
                                Toast.makeText(HomePage.this, t.getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        });*/
    }

    private void hadleLoginDialog() {
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(view).show();

        Button loginBtn = view.findViewById(R.id.SingIn);
        EditText username = view.findViewById(R.id.usernamesi);
        EditText password = view.findViewById(R.id.passwordsi);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();

                map.put("username", username.getText().toString());
                map.put("password", password.getText().toString());

                Call<LoginResult> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                        if (response.code() == 200) {

                            LoginResult result = response.body();
                            Toast.makeText(HomePage.this, "SIGNED IN",
                                    Toast.LENGTH_LONG).show();
                            startActivity(new Intent(HomePage.this, MainAplicationPage.class));

                        } else if (response.code() == 404) {
                            Toast.makeText(HomePage.this, "Wrong Credentials",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(HomePage.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    /*private void handleLoginDialog() {
                 View view = getLayoutInflater().inflate(R.layout.activity_main, null);

                 AlertDialog.Builder builder = new AlertDialog.Builder(this);

                 builder.setView(view).show();

                 Button loginBtn = view.findViewById(R.id.SingIn);
                 EditText username = view.findViewById(R.id.usernamesi);
                 EditText password = view.findViewById(R.id.passwordsi);

                 loginBtn.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         HashMap<String, String> map = new HashMap<>();

                         map.put("username", username.getText().toString());
                         map.put("password", password.getText().toString());

                         Call<LoginResult> call = retrofitInterface.executeLogin(map);

                         call.enqueue(new Callback<LoginResult>() {
                             @Override
                             public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                                 if (response.code() == 200) {

                                     LoginResult result = response.body();
                                     Toast.makeText(HomePage.this, "SIGNED IN",
                                             Toast.LENGTH_LONG).show();
                                     startActivity(new Intent(HomePage.this, MainAplicationPage.class));

                                 } else if (response.code() == 404) {
                                     Toast.makeText(HomePage.this, "Wrong Credentials",
                                             Toast.LENGTH_LONG).show();
                                 }
                             }

                             @Override
                             public void onFailure(Call<LoginResult> call, Throwable t) {
                                 Toast.makeText(HomePage.this, t.getMessage(),
                                         Toast.LENGTH_LONG).show();
                             }
                         });
                     }
                 });
             }*/
        private void handleSignupDialog () {
            View view = getLayoutInflater().inflate(R.layout.register_pop, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view).show();

            Button signupBtn = view.findViewById(R.id.registernow);
            final EditText username = view.findViewById(R.id.username);
            final EditText email = view.findViewById(R.id.email);
            final EditText password = view.findViewById(R.id.password);

            signupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HashMap<String, String> map = new HashMap<>();

                    map.put("username", username.getText().toString());
                    map.put("email", email.getText().toString());
                    map.put("password", password.getText().toString());

                    Call<Void> call = retrofitInterface.executeSignup(map);

                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                            if (response.code() == 200) {
                                Toast.makeText(HomePage.this,
                                        "Signed up successfully", Toast.LENGTH_LONG).show();
                            } else if (response.code() == 400) {
                                Toast.makeText(HomePage.this,
                                        "Already registered", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            Toast.makeText(HomePage.this, t.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
    }
