package com.example.guill.marvel.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guill.marvel.App.MyApp;
import com.example.guill.marvel.R;
import com.example.guill.marvel.adapter.HeroesAdapter;
import com.example.guill.marvel.model.Hero;
import com.example.guill.marvel.viewmodel.HeroesViewModel;
import com.example.guill.marvel.viewmodel.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroesAdapter adapter;
    List<Hero> heroes;

    @Inject
    ViewModelFactory viewModelFactory;
    HeroesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ((MyApp) getApplication()).getNetComponent().inject(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HeroesViewModel.class);

        viewModel.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
