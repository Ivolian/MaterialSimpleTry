package com.ivo.materialsimpletry.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ivo.materialsimpletry.R;


public class ChoicesFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button button;
        return inflater.inflate(R.layout.fragment_greenmatter_choices, null);
	}

}
