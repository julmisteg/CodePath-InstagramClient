package com.example.julmiste.instagramclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by gaetanejulmiste on 5/10/16.
 */
public class InstagramCommentActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ListView lvComments =  (ListView) findViewById(R.id.lvComments);

    }
}
