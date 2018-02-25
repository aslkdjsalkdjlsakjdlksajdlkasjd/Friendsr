// Minor Programmeren, Unit3, Friendsr: a social friends app
// that allows you to view people’s profiles and some information about them.
// When the user first loads the app, it will show a list of available users.
// The user can click on each one to see a bigger photo and get more information about that user.
// On the screen is a way to rate the user
//
//Nina Boelsums 10742670


package com.example.s156543.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Modelling friends
        Friend Arya = new Friend("Arya", R.drawable.arya,
                "A girl is Arya Stark of Winterfell. And I'm going home.");
        Friend Cersei = new Friend("Cersei", R.drawable.cersei,
                "When you play the game of thrones, you win or you die.");
        Friend Dany = new Friend("Daenerys", R.drawable.daenerys,
                "I am the dragon's daughter, and I swear to you that those who would harm you will die screaming.");
        Friend Jaime = new Friend("Jaime", R.drawable.jaime,
                "The things I do for love.");
        Friend Jon = new Friend("Jon", R.drawable.jon,
                "I'm a whiny emo bitch");
        Friend Jorah = new Friend("Jorah", R.drawable.jorah,
                "Hi I'm Jorah and I'm too old for Dany and should back the fuck off");
        Friend Margaery = new Friend("Margaery", R.drawable.margaery,
                "Oh look, the pie!");
        Friend Melisandre = new Friend("Melisandre", R.drawable.melisandre,
                "The night is dark and full of terrors.");
        Friend Sansa = new Friend("Sansa", R.drawable.sansa,
                "My skin has turned to porcelain, to ivory, to steel");
        Friend Tyrion = new Friend("Tyrion", R.drawable.tyrion,
                "That's what I do: I drink and I know things");

        friends.add(Arya);
        friends.add(Cersei);
        friends.add(Dany);
        friends.add(Jaime);
        friends.add(Jon);
        friends.add(Jorah);
        friends.add(Margaery);
        friends.add(Melisandre);
        friends.add(Sansa);
        friends.add(Tyrion);

        // Connecting adapter and onitemclicklistener
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gv = findViewById(R.id.grid);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new GridItemClickListener());
    }


    // Listens if a grid item is clicked on
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        Friend clickedFriend;
        // When clicked, stores Friend object in intent
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            setIntent();
        }

        // connects this activity with the ProfileActivity
        public void setIntent(){
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
