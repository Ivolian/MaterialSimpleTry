package com.ivo.materialsimpletry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.ivo.materialsimpletry.MyFragment;
import com.ivo.materialsimpletry.MyFragment2;
import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.ivo.materialsimpletry.greenmatter.SelectColorActivity;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.InjectView;


public class MainActivity extends ToolbarActivity {

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar("Material App", true);
        initDrawLayout();

        if (savedInstanceState == null) {
            displayFragment(new MyFragment());
        }
//             mTitle = savedInstanceState.getString(STATE_ACTIONBAR_TITLE);
    }

    private void initDrawLayout() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setDrawerShadow(R.drawable.navigation_drawer_shadow, Gravity.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        displayFragment(new MyFragment2());
//        startSelectColorActivity();
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

    //    @OnClick(R.id.button)
    public void onClick() {
        SnackbarManager.show(
                Snackbar.with(MainActivity.this)
                        .text("Different colors!!!")
                        .margin(15, 15)
                        .textColor(0x000000)
                        .color(ColorOverrider.getInstance(null).colorAccent)
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    private void startSelectColorActivity() {

        Intent intent = new Intent(this, SelectColorActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }

    public void displayFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
    }

}
