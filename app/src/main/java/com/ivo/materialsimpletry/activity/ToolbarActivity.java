package com.ivo.materialsimpletry.activity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.activity.MatActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ToolbarActivity extends MatActivity {

    @InjectView(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {

        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    public void initToolbar(String title) {

        initToolbar(title, false);
    }

    public void initToolbar(String title, boolean displayHomeAsUpEnable) {

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);   // 使 toolbar 有效，比如绑定 activity 菜单
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

        // 更细节的个性化主题，参考GreenMatter的Simple
        return ColorOverrider.getInstance(palette).applyOverride(palette);
    }

}
