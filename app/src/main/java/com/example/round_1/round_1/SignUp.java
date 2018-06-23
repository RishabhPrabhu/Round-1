package com.example.round_1.round_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;


public class SignUp extends AppCompatActivity implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {

    private Toolbar toolbar;
    private MaterialEditText full_name;
    private MaterialEditText email;
    private MaterialEditText dob;
    private MaterialEditText contact_number;
    private MaterialEditText password;
    private MaterialEditText confirm_password;
    private Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Sign Up");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        full_name = (MaterialEditText) findViewById(R.id.full_name);
        email = (MaterialEditText) findViewById(R.id.email);
        dob = (MaterialEditText) findViewById(R.id.dob);
        contact_number = (MaterialEditText) findViewById(R.id.contact_number);
        password = (MaterialEditText) findViewById(R.id.password);
        confirm_password = (MaterialEditText) findViewById(R.id.confirm_password);
        done= (Button) findViewById(R.id.done);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                        SignUp.this,
                        now.get(java.util.Calendar.YEAR),
                        now.get(java.util.Calendar.MONTH),
                        now.get(java.util.Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,PurchasePlan.class));
            }
        });
    }

    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        dob.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
    }
}

