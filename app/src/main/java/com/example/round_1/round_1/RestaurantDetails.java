package com.example.round_1.round_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import static android.widget.Toast.LENGTH_SHORT;

public class RestaurantDetails extends AppCompatActivity {

    //pop up variables
    private EditText email_pop_up;
    private EditText write_review;
    private TextView smiley_box_1;
    private TextView smiley_box_2;
    private TextView smiley_box_3;
    private TextView smiley_box_4;
    private TextView smiley_box_5;
    private LinearLayout drink1;
    private LinearLayout drink2;
    private LinearLayout drink3;
    private LinearLayout drink_more;
    private Switch been_there;

    private int seekBarValues = 0;
    //layout variables
    private Button rate_and_review;
    private TextView open_status;
    private ImageView venue_rating;
    private int rating = 3;
    private boolean open_status_value;
    private boolean been_there_counter = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Restaurant Details");

        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rate_and_review = (Button) findViewById(R.id.rate_and_review);
        been_there = (Switch) findViewById(R.id.been_there);
        open_status = (TextView) findViewById(R.id.open_status);
        venue_rating = (ImageView) findViewById(R.id.venue_rating);

        drink1 = (LinearLayout) findViewById(R.id.drink1);
        drink2 = (LinearLayout) findViewById(R.id.drink2);
        drink3 = (LinearLayout) findViewById(R.id.drink3);
        drink_more = (LinearLayout) findViewById(R.id.drink_more);
        //rate and review pop up
        rate_and_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialDialog dialog = new MaterialDialog.Builder(RestaurantDetails.this)
                        .title("Rate and Review")
                        .customView(R.layout.rate_and_review_pop_up, true)
                        .positiveText("Submit")
                        .negativeText("Cancel")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Toast.makeText(getApplicationContext(), "Review Submitted Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RestaurantDetails.this, RestaurantDetails.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }

                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Action cancelled by user", Toast.LENGTH_SHORT).show();
                            }
                        }).build();
                email_pop_up = (EditText) dialog.getCustomView().findViewById(R.id.email_pop_up);
                smiley_box_1 = (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_1);
                smiley_box_2 = (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_2);
                smiley_box_3 = (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_3);
                smiley_box_4 = (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_4);
                smiley_box_5 = (TextView) dialog.getCustomView().findViewById(R.id.smiley_box_5);
                //setting default boxes
                smiley_box_1.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_2.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_3.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_4.setBackgroundResource(R.drawable.smiley_box_unpressed);
                smiley_box_5.setBackgroundResource(R.drawable.smiley_box_unpressed);
                //implementing on click listener
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
                write_review = (EditText) dialog.getCustomView().findViewById(R.id.write_review);
                dialog.show();

            }
        });
        //change the state of been there button as an indicator
        been_there.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(getApplication(), "You have marked as BEEN THERE to this restaurant.", LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(), "You have unmarked as BEEN THERE to this restaurant.", LENGTH_SHORT).show();
                }
            }
        });

        //read the rating value from db and pass it to the ratingActivator func to set emoji
        ratingActivator(rating);

        drink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantDetails.this, FeaturedDrink.class));
                Toast.makeText(getApplicationContext(), "Drink 1 Details", Toast.LENGTH_SHORT).show();
            }
        });
        drink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantDetails.this, FeaturedDrink.class));
                Toast.makeText(getApplicationContext(), "Drink 2 Details", Toast.LENGTH_SHORT).show();
            }
        });
        drink3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantDetails.this, FeaturedDrink.class));
                Toast.makeText(getApplicationContext(), "Drink 3 Details", Toast.LENGTH_SHORT).show();
            }
        });
        drink_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This featur is yet to be added.", LENGTH_SHORT).show();
            }
        });
    }

    public void ratingActivator(int ratingValue) {
        if (ratingValue == 1)
            venue_rating.setImageResource(R.drawable.rating_0_to_1);
        else if (ratingValue == 2)
            venue_rating.setImageResource(R.drawable.rating_1_to_2);
        else if (ratingValue == 3)
            venue_rating.setImageResource(R.drawable.rating_2_to_3);
        else if (ratingValue == 4)
            venue_rating.setImageResource(R.drawable.rating_3_to_4);
        else if (ratingValue == 5)
            venue_rating.setImageResource(R.drawable.rating_4_to_5);
    }
}
