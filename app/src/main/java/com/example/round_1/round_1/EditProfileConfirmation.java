package com.example.round_1.round_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

public class EditProfileConfirmation extends AppCompatActivity {

    private MaterialEditText otp;
    private ImageView send;
    private TextView resend_otp;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_confirmation);

        otp= (MaterialEditText) findViewById(R.id.otp);
        send= (ImageView) findViewById(R.id.send);
        resend_otp= (TextView) findViewById(R.id.resend_otp);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Edit Profile Confirmation");

        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
