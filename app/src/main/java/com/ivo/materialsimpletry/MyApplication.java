package com.ivo.materialsimpletry;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.ivo.materialsimpletry.volley.MyVolley;


public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {

        return instance;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        init();
    }

    private void init() {

        instance = this;
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
        MyVolley.init(this);
    }

}
