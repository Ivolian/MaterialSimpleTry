package com.ivo.materialsimpletry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.ivo.materialsimpletry.greenmatter.SelectColorActivity;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.OnClick;


public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar("Material App", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        startSelectColorActivity();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // 设置主题颜色之后
        if (resultCode == SelectColorActivity.SELECT_COLOR_SUCCESS) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    recreate();
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.button)
    public void onClick() {
        SnackbarManager.show(
                Snackbar.with(MainActivity.this)
                        .text("Different colors!!!")
                        .margin(15, 15)
                        .textColor(0x000000)
                        .color(ColorOverrider.getInstance(null).colorAccent)
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    private void startSelectColorActivity(){

        Intent intent = new Intent(this, SelectColorActivity.class);
        startActivityForResult(intent, 1);
    }

}
