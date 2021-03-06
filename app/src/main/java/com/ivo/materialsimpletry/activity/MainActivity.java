package com.ivo.materialsimpletry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.activity.base.ToolbarActivity;
import com.ivo.materialsimpletry.fragment.InputFragment;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.ivo.materialsimpletry.greenmatter.activity.SelectColorActivity;
import com.ivo.materialsimpletry.greenmatter.fragment.ButtonFragment;
import com.ivo.materialsimpletry.greenmatter.fragment.ChoicesFragment;
import com.ivo.materialsimpletry.greenmatter.fragment.ProgressFragment;
import com.melnykov.fab.FloatingActionButton;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ToolbarActivity {

    final String TOOLBAR_TITLE = "toolbar_title";

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.nav_view)
    NavigationView navigationView;

    @InjectView(R.id.fab)
    FloatingActionButton fab;

    ActionBarDrawerToggle actionBarDrawerToggle;

    String toolbarTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(toolbarTitle, true);
        initDrawLayout();
        initNavigationView();

        if (savedInstanceState == null) {
            displayFragment(new InputFragment());
            setToolbarTitle(R.string.nav_input);
        } else {
            setToolbarTitle(savedInstanceState.getString(TOOLBAR_TITLE));
        }
    }

    private void initDrawLayout() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setDrawerShadow(R.drawable.navigation_drawer_shadow, GravityCompat.START);
    }

    private void initNavigationView() {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.nav_input:
                                displayFragment(new InputFragment());
                                setToolbarTitle(R.string.nav_input);
                                break;
                            case R.id.nav_choice:
                                displayFragment(new ChoicesFragment());
                                setToolbarTitle(R.string.nav_choice);
                                break;
                            case R.id.nav_progress:
                                displayFragment(new ProgressFragment());
                                setToolbarTitle(R.string.nav_progress);
                                break;
                            case R.id.nav_button:
                                displayFragment(new ButtonFragment());
                                setToolbarTitle(R.string.nav_button);
                                break;
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.select_color:
                drawerLayout.openDrawer(GravityCompat.END);
                return true;
            case R.id.setting:
                startActivity(SettingActivity.class);
                return true;
            case R.id.tablayout:
                startActivity(TabLayoutActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START) || drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

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

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TOOLBAR_TITLE, toolbarTitle);
    }


    @OnClick(R.id.fab)
    public void startSelectColorActivity() {

        Intent intent = new Intent(this, SelectColorActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, fab, "fab");
        ActivityCompat.startActivityForResult(this, intent, 1, activityOptions.toBundle());
    }

    private void setToolbarTitle(int stringResId) {

        setToolbarTitle(getResources().getString(stringResId));
    }

    private void setToolbarTitle(String toolbarTitle) {

        this.toolbarTitle = toolbarTitle;
        toolbar.setTitle(toolbarTitle);
    }

    // TODO 直接 replace 会出现顿卡现象，还是预留 fragment 比较好
    // TODO 方法1 使用 viewpager 管理 fragment
    // TODO 方法2 使用 add hide 方法
    // TODO 方法3 看看别人是怎么做的
    private void displayFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void showMessage() {

        SnackbarManager.show(
                Snackbar.with(this)
                        .position(Snackbar.SnackbarPosition.BOTTOM)
                        .margin(15, 15)
                        .color(ColorOverrider.getInstance(this).getColorPrimary())
                        .text("提示信息"));
    }
}
