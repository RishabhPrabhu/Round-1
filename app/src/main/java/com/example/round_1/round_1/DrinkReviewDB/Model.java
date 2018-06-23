package com.example.round_1.round_1.DrinkReviewDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.round_1.round_1.Data.ReviewData;

import java.util.ArrayList;

/**
 * Created by shadab on 6/28/2016.
 */
public class Model extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ReviewData.db";
    public static final String TABLE_NAME = "Review";
    public static final String COLUMN_ONE = "id";
    public static final String COLUMN_TWO = "email";
    public static final String COLUMN_THREE= "rate";
    public static final String COLUMN_FOUR = "review";

    public SQLiteDatabase db;


    public Model(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        this.db = db;
        db.execSQL(
                "create table  " +TABLE_NAME +
                        "("+ COLUMN_ONE +" integer primary key , "+COLUMN_TWO+" text ,"+COLUMN_THREE+" text, "+COLUMN_FOUR+" text)"
        );

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData  ( String column_two,String column_three, String column_four)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(
                "create  table if not exists " +TABLE_NAME +
                        "("+ COLUMN_ONE +" integer primary key , "+COLUMN_TWO+" text ,"+COLUMN_THREE+" text, "+COLUMN_FOUR+" text,)"
        );

        db.execSQL("INSERT INTO "+TABLE_NAME+"(title,description) VALUES('"+ column_two+"','"+column_three+"' )");


        return true;
    }


    public ArrayList<ReviewData> getAllData()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL(
                "create  table if not exists " +TABLE_NAME +
                        "("+ COLUMN_ONE +" integer primary key , "+COLUMN_TWO+" text ,"+COLUMN_THREE+" text, "+COLUMN_FOUR+" text)"
        );

        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        ArrayList<ReviewData> data = new ArrayList<>();

        while(res.isAfterLast() == false){

            ReviewData reviewData = new ReviewData();

            reviewData.setEmail(res.getString(res.getColumnIndex(COLUMN_TWO)));
            //reviewData.setEmoji(res.getString(res.getColumnIndex(COLUMN_THREE)));
            reviewData.setReview(res.getString(res.getColumnIndex(COLUMN_FOUR)));


            data.add(reviewData);

            res.moveToNext();
        }

        return data;
    }

}



