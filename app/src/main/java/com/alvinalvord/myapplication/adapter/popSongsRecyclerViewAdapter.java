package com.alvinalvord.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alvinalvord.myapplication.model.iTunesData;
import com.squareup.picasso.Picasso;

import org.alvinalvord.myapplication.R;

public class popSongsRecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private iTunesData data;

    public popSongsRecyclerViewAdapter(Context context, iTunesData data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.pop_songs_recycler_view_entry, viewGroup, false);
        return new PopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PopSongsViewHolder popSongsViewHolder = (PopSongsViewHolder) viewHolder;


        Picasso.with(context).load(data.getResults().get(i).getArtworkUrl100()).into(popSongsViewHolder.imageView);
        popSongsViewHolder.titleTextView.setText(data.getResults().get(i).getTrackName());
        popSongsViewHolder.artistTextView.setText(data.getResults().get(i).getArtistName());
    }

    @Override
    public int getItemCount() {
        return data.getResultCount();
    }

    private class PopSongsViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView titleTextView;
        TextView artistTextView;

        PopSongsViewHolder(View view) {
            super(view);
            this.view = view;
            imageView = view.findViewById(R.id.entry_imageview);
            titleTextView = view.findViewById(R.id.entry_title_textview);
            artistTextView = view.findViewById(R.id.entry_artist_textview);
        }
    }
}
