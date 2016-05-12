package com.example.julmiste.instagramclient;

import java.util.ArrayList;

/**
 * Created by julmiste on 5/8/16.
 */
public class InstagramPhoto {
    public String username;
    public String caption;
    public String imageUrl;
    public int imageHeight;
    public int likesCount;
    public int commentCount;
    public String profilePicture;
    public long createdTime;
    public ArrayList<InstagramComment> instaComments;

}
