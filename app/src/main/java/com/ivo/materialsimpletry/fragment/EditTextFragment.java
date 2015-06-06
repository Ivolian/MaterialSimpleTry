package com.ivo.materialsimpletry.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.fragment.base.BaseFragment;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Arrays;

import butterknife.InjectView;


public class EditTextFragment extends BaseFragment {

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_edittext;
    }

    @InjectView(R.id.autocompletetext)
    MaterialAutoCompleteTextView autoCompleteTextView;

    @InjectView(R.id.betterspinner)
    MaterialBetterSpinner betterSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        initViews();

        return rootView;
    }

    private void initViews() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, Arrays.asList("one", "two","three"));
        autoCompleteTextView.setAdapter(adapter);
        betterSpinner.setAdapter(adapter);
    }

}
