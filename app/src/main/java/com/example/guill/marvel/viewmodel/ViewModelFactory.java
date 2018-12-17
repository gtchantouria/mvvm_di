package com.example.guill.marvel.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Retrofit mRetrofit;

    @Inject
    public ViewModelFactory(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HeroesViewModel.class)) {
            return (T) new HeroesViewModel(mRetrofit);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
