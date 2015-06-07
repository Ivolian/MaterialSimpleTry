package com.ivo.materialsimpletry.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.adapter.MainActivityPagerAdapter;
import com.ivo.materialsimpletry.fragment.base.BaseFragment;

import butterknife.InjectView;


public class TabLayoutFragment extends BaseFragment {

    @Override
    public int getLayoutResId() {

        return R.layout.fragment_tablayout;
    }

    @InjectView(R.id.tabs)
    TabLayout tabLayout;

    @InjectView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        initViews();

        return rootView;
    }

    private void initViews() {

        viewPager.setAdapter(new MainActivityPagerAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

}
