package com.example.s156543.friendsr;

import java.io.Serializable;

// Friend Object
public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;

    // Object's name, picture and Bio are set in the MainActivity's OnCreate
    public Friend(String name ,int drawableId, String bio) {
        this.name = name;
        this.drawableId = drawableId;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getImgId() {
        return drawableId;
    }
}
