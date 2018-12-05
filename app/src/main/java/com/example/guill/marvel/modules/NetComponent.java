package com.example.guill.marvel.modules;

import com.example.guill.marvel.ui.MainActivity;
import com.example.guill.marvel.viewmodel.HeroesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
    void inject(HeroesViewModel heroesViewModel);
}
