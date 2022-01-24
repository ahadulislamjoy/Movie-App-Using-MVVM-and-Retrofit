package com.example.movieapp.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.View.Adapter.TopMovieListAdapter;
import com.example.movieapp.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieListViewModel mViewmodel;
    private TopMovieListAdapter topMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        mViewmodel = new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewmodel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                topMovieListAdapter = new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(topMovieListAdapter);

            }
        });
    }
}