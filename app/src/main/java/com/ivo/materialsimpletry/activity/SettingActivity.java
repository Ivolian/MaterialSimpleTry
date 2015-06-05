package com.ivo.materialsimpletry.activity;

import android.os.Bundle;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.activity.base.ToolbarActivity;
import com.r0adkll.slidr.Slidr;


public class SettingActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initToolbar("设置", true);

        Slidr.attach(this);
    }
}
