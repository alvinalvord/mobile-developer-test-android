package com.alvinalvord.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.alvinalvord.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView popSongsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContent ();
    }

    private void initContent() {
        popSongsRecyclerView = findViewById(R.id.pop_songs_recycler_view);
    }

}
