package com.example.movieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;

import java.util.List;
import java.util.zip.Inflater;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.myViewHolder>{
    private Context context;
    private List<Result> mlist;

    public TopMovieListAdapter(Context context, List<Result> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.movie_single_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.mTitle.setText(mlist.get(position).getTitle());
        holder.mRating.setText(mlist.get(position).getVoteAverage().toString());
        holder.mRelease.setText(mlist.get(position).getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + mlist.get(position).getPosterPath()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mTitle,mRating,mRelease;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.avatarImageView);
            mTitle = itemView.findViewById(R.id.titleTextView);
            mRating = itemView.findViewById(R.id.ratingTextView);
            mRelease = itemView.findViewById(R.id.releaseTextView);
        }
    }
}
