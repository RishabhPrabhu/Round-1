package com.example.round_1.round_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class PurchasePlan extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private LinearLayout standard_monthly;
    private LinearLayout standard_half_yearly;
    private LinearLayout standard_yearly;
    private LinearLayout elite_monthly;
    private LinearLayout elite_half_yearly;
    private LinearLayout elite_yearly;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_plan);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Purchase Plans");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        standard_monthly = (LinearLayout) findViewById(R.id.standard_monthly);
        standard_half_yearly = (LinearLayout) findViewById(R.id.standard_half_yearly);
        standard_yearly = (LinearLayout) findViewById(R.id.standard_yearly);
        elite_monthly = (LinearLayout) findViewById(R.id.elite_monthly);
        elite_half_yearly = (LinearLayout) findViewById(R.id.elite_half_yearly);
        elite_yearly = (LinearLayout) findViewById(R.id.elite_yearly);

        standard_monthly.setOnClickListener(this);
        standard_half_yearly.setOnClickListener(this);
        standard_yearly.setOnClickListener(this);
        elite_monthly.setOnClickListener(this);
        elite_half_yearly.setOnClickListener(this);
        elite_yearly.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        MaterialDialog dialog = new MaterialDialog.Builder(PurchasePlan.this)
                .title("Confirmation")
                .customView(R.layout.data_booking, true)
                .positiveText("Book")
                .negativeText("Cacncel")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(getApplicationContext(), "Plan booked successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PurchasePlan.this, HomePage.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }

                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.cancel();
                    }
                })
                .build();

        data = (TextView) dialog.getCustomView().findViewById(R.id.data);
        switch (view.getId()) {
            case R.id.standard_monthly:
                data.setText("You have selected Standard Monthly Plan which costs Rs. 999\nAre you sure you want to puchase this plan?");
                break;
            case R.id.standard_half_yearly:
                data.setText("You have selected Standard Half Yearly Plan which costs Rs. 5399\nAre you sure you want to puchase this plan?");
                break;
            case R.id.standard_yearly:
                data.setText("You have selected Standard Yearly Plan which costs Rs. 9599\nAre you sure you want to puchase this plan?");
                break;
            case R.id.elite_monthly:
                data.setText("You have selected Elite Monthly Plan which costs Rs. 1999\nAre you sure you want to puchase this plan?");
                break;
            case R.id.elite_half_yearly:
                data.setText("You have selected Elite Half Yearly Plan which costs Rs. 10799\nAre you sure you want to puchase this plan?");
                break;
            case R.id.elite_yearly:
                data.setText("You have selected Elite Yearly Plan which costs Rs. 19199\nAre you sure you want to puchase this plan?");
                break;
        }
        dialog.show();
    }
}
