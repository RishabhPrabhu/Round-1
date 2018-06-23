package com.example.round_1.round_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PlansAndBills extends AppCompatActivity {

    private Toolbar toolbar;
    private Button changePlan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_and_bills);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Plans And Bills");

        changePlan= (Button) findViewById(R.id.changePlan);
        changePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlansAndBills.this,PurchasePlan.class));
            }
        });
    }
}
