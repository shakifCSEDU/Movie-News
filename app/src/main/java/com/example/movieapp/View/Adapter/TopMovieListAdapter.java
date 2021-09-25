package com.example.movieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;
import com.squareup.picasso.Picasso;


import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder>{
    private Context context;
    private List<Result>results;

    public TopMovieListAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =   LayoutInflater.from(context).inflate(R.layout.single_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.title.setText(results.get(position).getTitle());
        holder.rating.setText(results.get(position).getVoteAverage().toString());
        holder.release.setText(results.get(position).getReleaseDate());
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+results.get(position).getPosterPath())
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,rating,release;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageViewId);
            title = (TextView)itemView.findViewById(R.id.titleTextViewId);
            release = (TextView)itemView.findViewById(R.id.releaseDateTextViewId);
            rating = (TextView)itemView.findViewById(R.id.ratingTextViewId);


        }
    }
}
