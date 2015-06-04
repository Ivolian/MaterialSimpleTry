package com.ivo.materialsimpletry.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ivo.materialsimpletry.fragment.ChoicesFragment;
import com.ivo.materialsimpletry.fragment.EditTextFragment;


public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)

    {
    switch (position){
        case 0:
            return new ChoicesFragment();
    }

        return new EditTextFragment();
    }

    @Override
    public int getCount() {



        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "title " + position;
    }

}
