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

    @InjectView(R.id.switch_compat)
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

    @OnClick(R.id.ll_switch_compat)
    public void llSwitchCompatOnClick() {

        switchCompat.setChecked(!switchCompat.isChecked());
    }

    @OnClick(R.id.ll_alert_dialog)
    public void showAlertDialog() {

        new MaterialDialog.Builder(this)
                .title("请确认")
                .content("Material Design Is Cool !")
                .positiveText("确定")
                .negativeText("取消")
                .negativeColor(ColorOverrider.getInstance(this).getColorPrimary())
                .show();
    }

    @OnClick(R.id.ll_choice_dialog)
    public void showRadioDialog() {

        new MaterialDialog.Builder(this)
                .title("请选择")
                .items(new CharSequence[]{"中国", "加拿大", "澳大利亚"})
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        return false;
                    }
                })
                .positiveText("确定")
                .show();
    }

    @OnClick(R.id.ll_progress_dialog)
    public void showProgressDialog() {

        new MaterialDialog.Builder(this)
                .title("加载中")
                .content("请稍后...")
                .progress(true, 0)
                .show();
    }
}
