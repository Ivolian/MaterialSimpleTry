package com.ivo.materialsimpletry.activity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.activity.MatActivity;

import app.mosn.zdepthshadowlayout.ZDepthShadowLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class ToolbarActivity extends MatActivity {

    @InjectView(R.id.toolbar)
    public Toolbar toolbar;

    @InjectView(R.id.zdepthshadowlayout)
    public ZDepthShadowLayout zDepthShadowLayout;

    @Override
    public void setContentView(int layoutResID) {

        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    public void initToolbar(String title, boolean displayHomeAsUpEnable) {

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUpEnable);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MatPalette overridePalette(MatPalette palette) {

        return ColorOverrider.getInstance(palette).applyOverride(palette);
    }

}
