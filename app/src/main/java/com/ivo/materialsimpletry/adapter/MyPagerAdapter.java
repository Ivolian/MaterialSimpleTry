package com.ivo.materialsimpletry.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ivo.materialsimpletry.greenmatter.fragment.ChoicesFragment;
import com.ivo.materialsimpletry.greenmatter.fragment.ProgressFragment;
import com.ivo.materialsimpletry.fragment.base.ButtonFragment;


public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChoicesFragment();
            case 1:
                return new ProgressFragment();
            case 2:
                return new ButtonFragment();
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "选择项";
            case 1:
                return "进度条";
            case 2:
                return "按钮";
            default:
                throw new RuntimeException();
        }
    }

}
