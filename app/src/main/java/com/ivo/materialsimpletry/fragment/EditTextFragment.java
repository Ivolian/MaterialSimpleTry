package com.ivo.materialsimpletry.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.fragment.base.BaseFragment;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialMultiAutoCompleteTextView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Arrays;

import butterknife.InjectView;


public class EditTextFragment extends BaseFragment {

    @InjectView(R.id.auto_complete_textview)
    MaterialAutoCompleteTextView autoCompleteTextView;

    @InjectView(R.id.multi_auto_complete_textview)
    MaterialMultiAutoCompleteTextView multiAutoCompleteTextView;

    @InjectView(R.id.better_spinner)
    MaterialBetterSpinner betterSpinner;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_edittext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        initViews();

        return rootView;
    }

    private void initViews() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, Arrays.asList("one", "two", "three"));
        autoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        betterSpinner.setAdapter(adapter);
    }

}
