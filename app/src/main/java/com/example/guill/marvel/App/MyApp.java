package com.example.guill.marvel.App;

import android.app.Application;

import com.example.guill.marvel.modules.AppModule;
import com.example.guill.marvel.modules.DaggerNetComponent;
import com.example.guill.marvel.modules.NetComponent;
import com.example.guill.marvel.modules.NetModule;

public class MyApp extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://www.simplifiedcoding.net/demos/"))
                .build();
    }

    public NetComponent getNetComponent(){
        return this.netComponent;
    }
}
