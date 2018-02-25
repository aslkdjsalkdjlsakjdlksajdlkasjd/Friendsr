package com.example.s156543.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import 	android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


// Pairs the list of Friend objects with the grid layout.
public class FriendsAdapter extends ArrayAdapter<Friend> {
    ArrayList<Friend> list1;

    // Called when new grid item displayed
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);

            TextView nameView = (TextView) convertView.findViewById(R.id.grid_item_name);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);

            // Set Friend object's name and picture to 'their own' grid location
            Friend currentFriend = list1.get(position);
            String currentName = currentFriend.getName();
            int imgId = currentFriend.getImgId();
            nameView.setText(currentName);
            imageView.setImageResource(imgId);

        }
        return convertView;
    }

    public FriendsAdapter(@NonNull Context context, int resource,
                          @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        Context cont = context;
        int id = resource;
        list1 = objects;
    }
}
