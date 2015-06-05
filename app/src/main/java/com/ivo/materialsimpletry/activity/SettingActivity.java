package com.ivo.materialsimpletry.activity;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CheckBox;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.activity.base.ToolbarActivity;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.r0adkll.slidr.Slidr;

import butterknife.InjectView;
import butterknife.OnClick;


public class SettingActivity extends ToolbarActivity {

    @InjectView(R.id.checkbox)
    CheckBox checkBox;

    @InjectView(R.id.switchcompat)
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initToolbar("设置", true);

        Slidr.attach(this);
    }

    @OnClick(R.id.ll_checkbox)
    public void llCheckBoxOnClick() {

        checkBox.setChecked(!checkBox.isChecked());
    }

    @OnClick(R.id.ll_switchcompat)
    public void llSwitchCompatOnClick() {

        switchCompat.setChecked(!switchCompat.isChecked());
    }

    @OnClick(R.id.ll_alert_dialog)
    public void showAlertDialog() {

        new MaterialDialog.Builder(this)
                .title("提示信息")
                .content("内容")
                .positiveColor(ColorOverrider.getInstance(this).getColorPrimary())
                .positiveText("确定")
                .negativeText("取消")
                .show();
    }

    @OnClick(R.id.ll_radio_dialog)
    public void showRadioDialog() {

        new MaterialDialog.Builder(this)
                .title("选择")
                .items(new CharSequence[]{"选项 1", "选项 2", "选项 3", "选项 4"})
                .itemsCallbackSingleChoice(1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        return true;
                    }
                })
                .positiveText("确认")
                .show();
    }

    @OnClick(R.id.ll_progress_dialog)
    public void showProgressDialog(){

        new MaterialDialog.Builder(this)
                .title("加载中")
                .content("请稍后...")
                .progress(true, 0)
                .show();
    }

}
