package com.example.realm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FavoriteMovieActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MovieModel> movielist;
    Bundle bundle;
    Realm realm;
    RealmHelper realmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movie);

        getSupportActionBar().setTitle("Favorite Movies");

        recyclerView = findViewById(R.id.rv_movies);

        recyclerView.setLayoutManager(new LinearLayoutManager(FavoriteMovieActivity.this));

        movielist = new ArrayList<>();

        RealmConfiguration configuration = new RealmConfiguration.Builder().allowWritesOnUiThread(true).build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        movielist = new ArrayList<>();

        movielist = realmHelper.getAllMovies();


    }
}