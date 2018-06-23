package com.example.round_1.round_1.Data;

import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shadab on 6/28/2016.
 */
public class ReviewData {
    private String email;
    private String review;

    public String getEmail() {
        return email.toString();
    }

    public void setEmail(String email) {
        this.email = email.toString();
    }

    public String getReview() {
        return review.toString();
    }

    public void setReview(String review) {
        this.review = review.toString();
    }
}
