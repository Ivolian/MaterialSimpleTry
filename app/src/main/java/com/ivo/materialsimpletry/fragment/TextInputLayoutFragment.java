package com.ivo.materialsimpletry.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.fragment.base.BaseFragment;

import butterknife.InjectView;


public class TextInputLayoutFragment extends BaseFragment {

    @Override
    public int getLayoutResourceId() {

        return R.layout.fragment_text_input_layout;
    }

    @InjectView(R.id.textInputLayout)
    TextInputLayout textInputLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString().trim();
                textInputLayout.setErrorEnabled(!text.equals(""));
                textInputLayout.setError(text);
            }
        });

        return rootView;
    }
}
