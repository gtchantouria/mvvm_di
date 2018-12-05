package com.example.guill.marvel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guill.marvel.R;
import com.example.guill.marvel.model.Hero;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>{
    Context context;
    List<Hero> heroes;

    public HeroesAdapter(Context context, List<Hero> heroesList){
        this.context = context;
        this.heroes = heroesList;
    }

    @NonNull
    @Override
    public HeroesAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.HeroViewHolder heroViewHolder, int index) {
        Hero hero = heroes.get(index);

        Glide.with(context).load(hero.getImageurl()).into(heroViewHolder.imageView);
        heroViewHolder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }


    public class HeroViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
