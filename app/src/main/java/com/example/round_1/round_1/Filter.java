package com.example.round_1.round_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Filter extends AppCompatActivity implements View.OnClickListener {

    private TextView sorting;
    private TextView restaurant_type;
    private TextView cost_for_two;
    private TextView distance;
    private TextView drinks_type;
    private TextView cuisine_type;
    private TextView open_or_close;

    private LinearLayout sorting_menu;
    private LinearLayout restaurant_type_menu;
    private LinearLayout cost_for_two_menu;
    private LinearLayout distance_menu;
    private LinearLayout drinks_type_menu;
    private LinearLayout cuisine_type_menu;
    private LinearLayout open_or_close_menu;

    private RadioButton sorting_popularity;
    private RadioButton sorting_distance;
    private RadioButton sorting_cost_for_two;
    private RadioButton sorting_high_to_low;
    private RadioButton sorting_low_to_high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Filters and Sort");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sorting = (TextView) findViewById(R.id.sorting);
        restaurant_type = (TextView) findViewById(R.id.restaurant_type);
        cost_for_two = (TextView) findViewById(R.id.cost_for_two);
        distance = (TextView) findViewById(R.id.distance);
        drinks_type = (TextView) findViewById(R.id.drinks_type);
        cuisine_type = (TextView) findViewById(R.id.cuisine_type);
        open_or_close = (TextView) findViewById(R.id.open_or_close);

        sorting_menu = (LinearLayout) findViewById(R.id.sorting_menu);
        restaurant_type_menu = (LinearLayout) findViewById(R.id.restaurant_type_menu);
        cost_for_two_menu = (LinearLayout) findViewById(R.id.cost_for_two_menu);
        distance_menu = (LinearLayout) findViewById(R.id.distance_menu);
        drinks_type_menu = (LinearLayout) findViewById(R.id.drinks_type_menu);
        cuisine_type_menu = (LinearLayout) findViewById(R.id.cuisine_type_menu);
        open_or_close_menu = (LinearLayout) findViewById(R.id.open_or_close_menu);

        sorting_popularity= (RadioButton) findViewById(R.id.sorting_popularity);
        sorting_distance= (RadioButton) findViewById(R.id.sorting_distance);
        sorting_cost_for_two= (RadioButton) findViewById(R.id.sorting_cost_for_two);
        sorting_high_to_low= (RadioButton) findViewById(R.id.sorting_high_to_low);
        sorting_low_to_high= (RadioButton) findViewById(R.id.sorting_low_to_high);

        sorting.setOnClickListener(this);
        restaurant_type.setOnClickListener(this);
        cost_for_two.setOnClickListener(this);
        distance.setOnClickListener(this);
        drinks_type.setOnClickListener(this);
        cuisine_type.setOnClickListener(this);
        open_or_close.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //set visibility gone to all
        sorting_menu.setVisibility(View.GONE);
        restaurant_type_menu.setVisibility(View.GONE);
        cost_for_two_menu.setVisibility(View.GONE);
        distance_menu.setVisibility(View.GONE);
        drinks_type_menu.setVisibility(View.GONE);
        cuisine_type_menu.setVisibility(View.GONE);
        open_or_close_menu.setVisibility(View.GONE);

        //set default color
        sorting.setTextColor(0xFFFFFFFF);
        sorting.setBackgroundResource(R.color.awesomeGrey);
        restaurant_type.setTextColor(0xFFFFFFFF);
        restaurant_type.setBackgroundResource(R.color.awesomeGrey);
        cost_for_two.setTextColor(0xFFFFFFFF);
        cost_for_two.setBackgroundResource(R.color.awesomeGrey);
        distance.setTextColor(0xFFFFFFFF);
        distance.setBackgroundResource(R.color.awesomeGrey);
        drinks_type.setTextColor(0xFFFFFFFF);
        drinks_type.setBackgroundResource(R.color.awesomeGrey);
        cuisine_type.setTextColor(0xFFFFFFFF);
        cuisine_type.setBackgroundResource(R.color.awesomeGrey);
        open_or_close.setTextColor(0xFFFFFFFF);
        open_or_close.setBackgroundResource(R.color.awesomeGrey);

        switch (view.getId()) {
            case R.id.sorting:
                sorting_menu.setVisibility(View.VISIBLE);
                sorting.setTextColor(0xFFF44336);
                sorting.setBackgroundResource(R.drawable.filter_pressed);
                //add toggle for radio sorting buttons
                break;
            case R.id.restaurant_type:
                restaurant_type_menu.setVisibility(View.VISIBLE);
                restaurant_type.setTextColor(0xFFF44336);
                restaurant_type.setBackgroundResource(R.drawable.filter_pressed);
                break;
            case R.id.cost_for_two:
                cost_for_two_menu.setVisibility(View.VISIBLE);
                cost_for_two.setTextColor(0xFFF44336);
                cost_for_two.setBackgroundResource(R.drawable.filter_pressed);
                break;
            case R.id.distance:
                distance_menu.setVisibility(View.VISIBLE);
                distance.setTextColor(0xFFF44336);
                distance.setBackgroundResource(R.drawable.filter_pressed);
                break;
            case R.id.drinks_type:
                drinks_type_menu.setVisibility(View.VISIBLE);
                drinks_type.setTextColor(0xFFF44336);
                drinks_type.setBackgroundResource(R.drawable.filter_pressed);
                break;
            case R.id.cuisine_type:
                cuisine_type_menu.setVisibility(View.VISIBLE);
                cuisine_type.setTextColor(0xFFF44336);
                cuisine_type.setBackgroundResource(R.drawable.filter_pressed);
                break;
            case R.id.open_or_close:
                open_or_close_menu.setVisibility(View.VISIBLE);
                open_or_close.setTextColor(0xFFF44336);
                open_or_close.setBackgroundResource(R.drawable.filter_pressed);
                break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.save) {
            Intent intent = new Intent(Filter.this, HomePage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Toast.makeText(getApplicationContext(),"Filters saved", LENGTH_SHORT).show();
            startActivity(intent);
        }
        if (id == R.id.cancel) {
            Intent intent = new Intent(Filter.this, HomePage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Toast.makeText(getApplicationContext(),"Filters cancelled", LENGTH_SHORT).show();
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
