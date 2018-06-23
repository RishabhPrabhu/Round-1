package com.example.round_1.round_1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class FeaturedDrink extends AppCompatActivity {
    private ImageView venue_rating;
    int rating = 5;
    private Button book_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_drink);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Featured Drinks");

        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        book_now = (Button) findViewById(R.id.book_now);
        venue_rating = (ImageView) findViewById(R.id.venue_rating);
        //read the rating value from db and pass it to the ratingActivator func to set emoji
        ratingActivator(rating);

        book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if not logged in
                MaterialDialog dialog = new MaterialDialog.Builder(FeaturedDrink.this)
                        .title("Oops")
                        .content("It seems that you are not logged in. Please Login or Sign Up to BOOK NOW.")
                        .positiveText("Login")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Intent intent = new Intent(FeaturedDrink.this, Login.class);
                                startActivity(intent);
                            }
                        })
                        .build();
                dialog.show();
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
