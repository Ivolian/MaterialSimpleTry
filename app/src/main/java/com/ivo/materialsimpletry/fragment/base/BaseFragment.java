package com.ivo.materialsimpletry.fragment.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment {

    abstract public int getLayoutResId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
