package com.ivo.materialsimpletry.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.fragment.base.BaseFragment;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Arrays;

import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnFocusChange;


public class InputFragment extends BaseFragment {

    @InjectView(R.id.auto_complete_textview)
    MaterialAutoCompleteTextView autoCompleteTextView;

    @InjectView(R.id.better_spinner)
    MaterialBetterSpinner betterSpinner;

    @InjectView(R.id.et_time)
    MaterialEditText etTime;

    @InjectView(R.id.et_date)
    MaterialEditText etDate;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_input;
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
        betterSpinner.setAdapter(adapter);

    }

    @OnFocusChange(R.id.et_time)
    public void etTimeOnFocused(boolean focused) {
        if (focused) {
            showTimePickerDialog();
        }
    }

    @OnClick(R.id.et_time)
    public void etTimeOnClick() {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String minStr = (minute > 9 ? "" : "0") + minute;
                etTime.setText(hourOfDay + ":" + minStr);
            }
        }, 12, 0, false).show();
    }


    @OnFocusChange(R.id.et_date)
    public void etDateOnFocused(boolean focused) {
        if (focused) {
            showDatePickerDialog();
        }
    }

    @OnClick(R.id.et_date)
    public void etDateOnClick() {
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                etDate.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
            }
        }, 2015, 6 - 1, 1).show();
    }
}
