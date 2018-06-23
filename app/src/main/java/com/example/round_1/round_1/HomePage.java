package com.example.round_1.round_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.round_1.round_1.Adapters.CardAdapter;
import com.example.round_1.round_1.Data.CardData;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class HomePage extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ListView listView;
    private CardAdapter database;
    private EditText myEditText;

    private ImageView option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Round - 1");

        ArrayList<CardData> list = new ArrayList<CardData>();
        for (int i = 1; i <= 5; i++) {
            CardData cd = new CardData();
            cd.setOpen_status("OPEN");
            cd.setLevel("Level: level" + i);
            cd.setType("Type: Type" + i);
            cd.setDistance(i + " Km");
            list.add(cd);
        }

        listView = (ListView) findViewById(R.id.listview);
        database = new CardAdapter(this, R.layout.activity_home_page_card, list);

        listView.setAdapter(database);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(HomePage.this, RestaurantDetails.class));
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nvView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                if (menuItem.getItemId() == R.id.explore) {
                    startActivity(new Intent(HomePage.this, RestaurantsExplored.class));
                }

                if (menuItem.getItemId() == R.id.tried_drinks) {
                    startActivity(new Intent(HomePage.this, DrinkDetail.class));
                }
                if (menuItem.getItemId() == R.id.bill) {
                    startActivity(new Intent(HomePage.this, PlansAndBills.class));
                }
                if (menuItem.getItemId() == R.id.share) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("type/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Download Round 1 App");
                    startActivity(Intent.createChooser(shareIntent, "How Do You Want To Share"));
                }
                if (menuItem.getItemId() == R.id.about) {
                    startActivity(new Intent(HomePage.this, AboutApp.class));
                }
                if (menuItem.getItemId() == R.id.faq) {
                    startActivity(new Intent(HomePage.this, FAQ.class));
                }
                if (menuItem.getItemId() == R.id.write_to_us) {
                    startActivity(new Intent(HomePage.this, WriteToUs.class));
                }
                if (menuItem.getItemId() == R.id.call_us) {
                    String number = "111-333-222-4";
                    String uri = "tel:" + number.trim();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }
                if (menuItem.getItemId() == R.id.rate_us) {
                    MaterialDialog dialog = new MaterialDialog.Builder(HomePage.this)
                            .title("Rate Us")
                            .content("You have been using Round 1 for a while.\nDo you want to rate us now?")
                            .positiveText("Rate Now")
                            .negativeText("Later")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Toast.makeText(getApplicationContext(), "Explicit Intent to Google Play", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                }

                            })
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Toast.makeText(getApplicationContext(), "Action cancelled by user", Toast.LENGTH_SHORT).show();
                                    dialog.cancel();
                                }
                            }).build();
                    dialog.show();

                }
                if (menuItem.getItemId() == R.id.terms_of_use) {
                    startActivity(new Intent(HomePage.this, TermsOfUse.class));
                }

                return false;
            }

        });


        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        option = (ImageView) findViewById(R.id.option);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, Filter.class));
            }
        });
        myEditText = (EditText) findViewById(R.id.myEditText);
        //myEditText.setText("12");

        View headerLayout = mNavigationView.inflateHeaderView(R.layout.nv_header);
        ImageView accessCard = (ImageView) headerLayout.findViewById(R.id.access_card);
        ImageView editProfile = (ImageView) headerLayout.findViewById(R.id.edit_profile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, EditProfile.class));
            }
        });
        accessCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, AccessCard.class));
            }
        });
        ImageView profile_pic = (ImageView) headerLayout.findViewById(R.id.profile_picture);
        TextView email = (TextView) headerLayout.findViewById(R.id.email);

/*        SharedPreferences sharedPref = getSharedPreferences("users", Context.MODE_PRIVATE);
        String username = sharedPref.getString("name", "NAME");
        String profile_url = sharedPref.getString("profile_url", "http://s3.amazonaws.com/37assets/svn/765-default-avatar.png");

        email.setText(username);
        Picasso.with(HomePage.this)
                .load(profile_url)
                .into(profile_pic);*/

    }
/*
    private class AllNotes extends AsyncTask<String, String, ArrayList<TaskData>> {

        @Override
        protected ArrayList<TaskData> doInBackground(String... params) {
            //get all the data from database
            return taskDatabase.getAllData();
        }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.drinks_left) {
            MaterialDialog dialog = new MaterialDialog.Builder(HomePage.this)
                    .title("Drinks Left")
                    .content("You have 12 drinks left from your subscription.")
                    .positiveText("Ok")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.cancel();
                        }
                    })
                    .build();
            dialog.show();
        }
        if (id == R.id.surprise_me) {
            Intent intent = new Intent(HomePage.this, FeaturedDrink.class);
            startActivity(intent);
        }
        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "This featur is yet to be added.", LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
