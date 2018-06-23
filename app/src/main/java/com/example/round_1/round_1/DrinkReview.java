package com.example.round_1.round_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.round_1.round_1.Data.ReviewData;
import com.example.round_1.round_1.DrinkReviewDB.Model;

import java.util.ArrayList;

public class DrinkReview extends AppCompatActivity {

    //pop up variables
    private EditText email_pop_up;
    private EditText write_review;
    private TextView smiley_box_1;
    private TextView smiley_box_2;
    private TextView smiley_box_3;
    private TextView smiley_box_4;
    private TextView smiley_box_5;


    private Button writereview;
    private TextView email;
    private EditText review;
    private ImageView venue_rating;

    private LinearLayout emoji;
    Model model = new Model(this);
    int ratingValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        writereview = (Button) findViewById(R.id.write_review);

        venue_rating= (ImageView) findViewById(R.id.venue_rating);

        //emoji= (LinearLayout) findViewById(R.id.emoji);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_review);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Drink Reviews");

        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        writereview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialDialog dialog = new MaterialDialog.Builder(DrinkReview.this)
                        .title("Write a Review")
                        .customView(R.layout.rate_and_review_pop_up, true)
                        .positiveText("save")
                        .negativeText("Cancel")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Toast.makeText(getApplicationContext(), "Review submitted successfully", Toast.LENGTH_SHORT).show();/*
                                Intent intent = new Intent(DrinkReview.this, DrinkReview.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);*/
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Action cancelled by user", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();


                email_pop_up = (EditText) dialog.getCustomView().findViewById(R.id.email_pop_up);
                smiley_box_1= (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_1);
                smiley_box_2= (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_2);
                smiley_box_3= (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_3);
                smiley_box_4= (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_4);
                smiley_box_5= (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_5);
                //setting default boxes
                smiley_box_1.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_2.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_3.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_4.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                //implemnting onclick listener
                smiley_box_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        smiley_box_1.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_2.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_3.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_4.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                    }
                });
                smiley_box_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        smiley_box_2.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_1.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_3.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_4.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                    }
                });
                smiley_box_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        smiley_box_3.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_1.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_2.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_4.setBackgroundResource(R.drawable.smiley_box_unpressed);
                        smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                    }
                });
                smiley_box_4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        smiley_box_4.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_1.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_2.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_3.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                    }
                });
                smiley_box_5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        smiley_box_1.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_2.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_3.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_4.setBackgroundResource(R.drawable.smiley_box_pressed);
                        smiley_box_5.setBackgroundResource(R.drawable.smiley_box_pressed);
                    }
                });
                dialog.show();


            }
        });
        ArrayList<ReviewData> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ReviewData data = new ReviewData();
            data.setEmail("This is  title " + i);
            data.setReview("this is the review " + i);

            list.add(data);
        }
/*
        NotesAdapter adapter = new NotesAdapter(this, R.layout.view_card, list);

        listView.setAdapter(adapter);*/

    }
}


