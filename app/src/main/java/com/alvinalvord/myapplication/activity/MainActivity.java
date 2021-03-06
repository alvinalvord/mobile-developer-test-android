package com.alvinalvord.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.alvinalvord.myapplication.adapter.popSongsRecyclerViewAdapter;
import com.alvinalvord.myapplication.model.iTunesData;
import com.alvinalvord.myapplication.services.iTunesRetrofit;
import com.alvinalvord.myapplication.services.iTunesService;

import org.alvinalvord.myapplication.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView popSongsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContent ();
    }

    private void initContent() {
        iTunesService service = iTunesRetrofit.getInstance().create(iTunesService.class);
        Call<iTunesData> call = service.getPopSongs();
        call.enqueue(new Callback<iTunesData>() {
            @Override
            public void onResponse(Call<iTunesData> call, Response<iTunesData> response) {
                Log.d ("call", "success");
                Log.d("response data", String.valueOf(response.body()));
                setRecyclerViewData (response.body());
            }

            @Override
            public void onFailure(Call<iTunesData> call, Throwable t) {
                Log.d ("call", "failed", t);
                Toast.makeText(MainActivity.this.getBaseContext(), "Failed to retrieve data from iTunes", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setRecyclerViewData(iTunesData data) {
        popSongsRecyclerView = findViewById(R.id.pop_songs_recycler_view);
        popSongsRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        popSongsRecyclerView.setAdapter(new popSongsRecyclerViewAdapter(getBaseContext(), data));
    }

}
