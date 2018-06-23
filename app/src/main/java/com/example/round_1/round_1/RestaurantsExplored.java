package com.example.round_1.round_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.round_1.round_1.Adapters.CardAdapter;
import com.example.round_1.round_1.Data.CardData;

import java.util.ArrayList;

public class RestaurantsExplored extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private CardAdapter database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_explored);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Restaurants Explored");


        //for back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        ArrayList<CardData> list = new ArrayList<CardData>();
        for (int i = 1; i <= 5; i++) {
            CardData cd = new CardData();
            cd.setOpen_status("OPEN");
            cd.setLevel("Level: level" + i);
            cd.setType("Type: Type" + i);
            cd.setDistance(i + " Km");
            list.add(cd);
        }

        listView = (ListView) findViewById(R.id.listView_explored);
        database = new CardAdapter(this,R.layout.restaurant_explored_card, list);

        listView.setAdapter(database);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(RestaurantsExplored.this, RestaurantDetails.class));
            }
        });

    }
}
