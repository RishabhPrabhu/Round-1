package com.example.round_1.round_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class Login extends AppCompatActivity {

    private MaterialEditText email;
    private MaterialEditText password;
    private Button login;
    private Button signup;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Login");
        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email= (MaterialEditText) findViewById(R.id.email);
        password= (MaterialEditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        signup= (Button) findViewById(R.id.sign_up);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,PurchasePlan.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });
    }
}
