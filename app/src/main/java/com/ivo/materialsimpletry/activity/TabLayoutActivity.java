package com.ivo.materialsimpletry.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.activity.base.ToolbarActivity;
import com.ivo.materialsimpletry.adapter.MainActivityPagerAdapter;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import butterknife.InjectView;
import butterknife.OnPageChange;


public class TabLayoutActivity extends ToolbarActivity {

    @InjectView(R.id.tabs)
    TabLayout tabLayout;

    @InjectView(R.id.viewpager)
    ViewPager viewPager;

    SlidrInterface slidrInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        slidrInterface = Slidr.attach(this);
        setContentView(R.layout.activity_tablayout);
        initToolbar("TabLayout", true);
        initViews();
    }

    private void initViews() {

        viewPager.setAdapter(new MainActivityPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnPageChange(value = R.id.viewpager, callback = OnPageChange.Callback.PAGE_SELECTED)
    public void onPageSelected(int position) {
        if (position == 0) {
            slidrInterface.unlock();
        } else {
            slidrInterface.lock();
        }
    }
}
