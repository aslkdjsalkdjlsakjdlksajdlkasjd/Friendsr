package com.example.s156543.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.SharedPreferences;

// Activity for viewing a Friend's profile
public class ProfileActivity extends AppCompatActivity {
    Friend retrievedFriend;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Retrieve current Friend from the intent
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Display Friend's name, picture, rating and bio
        ratingBar  = (RatingBar) findViewById(R.id.profileRating);
        TextView nameView = (TextView) findViewById(R.id.profileName);
        ImageView imageView = (ImageView) findViewById(R.id.profileImage);
        TextView bioView = (TextView) findViewById(R.id.profileBio);

        ratingBar.setRating(retrieveRating());
        nameView.setText(retrievedFriend.getName());
        imageView.setImageResource(retrievedFriend.getImgId());
        bioView.setText(retrievedFriend.getBio());

        // Initialize listener on Friend's rating bar
        RatingBar r = findViewById(R.id.profileRating);
        r.setOnRatingBarChangeListener(new RatingListen());
    }

    // Listener for rating bar
    private class RatingListen implements RatingBar.OnRatingBarChangeListener {

        public void onRatingChanged(RatingBar bar, float rate, boolean bool){
            bar  = findViewById(R.id.profileRating);

            // Access SharedPreferences and edit rating value of current Friend
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(retrievedFriend.getName(), bar.getRating());
            editor.apply();
        }
    }

    // Retrieves rating when Friend's profile is re-accessed
    public float retrieveRating(){

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(retrievedFriend.getName(), 0);

        if(rating != 0) {
            return rating;
        }
        else {
            return 0;
        }
    }
}
