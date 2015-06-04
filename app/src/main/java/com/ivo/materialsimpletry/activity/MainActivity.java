package com.ivo.materialsimpletry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.fragment.EditTextFragment;
import com.ivo.materialsimpletry.fragment.TabLayoutFragment;
import com.ivo.materialsimpletry.greenmatter.SelectColorActivity;

import butterknife.InjectView;


public class MainActivity extends ToolbarActivity {

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @InjectView(R.id.nav_view)
    NavigationView navigationView;

    String title = "Material App";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(title, true);
        initDrawLayout();
        initNavigationView();

        if (savedInstanceState == null) {
            displayFragment(new TabLayoutFragment());
            changeTitle("TabLayout");
        } else {
            changeTitle(savedInstanceState.getString("title"));
        }
//             mTitle = savedInstanceState.getString(STATE_ACTIONBAR_TITLE);
    }

    private void initNavigationView() {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        drawerLayout.closeDrawer(GravityCompat.START);

                        switch (menuItem.getItemId()) {
                            case R.id.nav_tablayout:
                                displayFragment(new TabLayoutFragment());
                                changeTitle("TabLayout");
                                break;
                            case R.id.nav_edittext:
                                displayFragment(new EditTextFragment());
                                changeTitle("EditText");
                                break;
                        }
                        return true;
                    }
                });
    }

    private void initDrawLayout() {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.setDrawerShadow(R.drawable.navigation_drawer_shadow, GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.theme:
//                displayFragment(new MyFragment2());
                startSelectColorActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displayFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void changeTitle(String title) {
        this.title = title;
        toolbar.setTitle(title);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("title", title);
    }

    private void startSelectColorActivity() {

        Intent intent = new Intent(this, SelectColorActivity.class);
        startActivityForResult(intent, 1);
    }

}
