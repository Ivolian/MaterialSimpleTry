package com.ivo.materialsimpletry.greenmatter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.ivo.materialsimpletry.R;
import com.ivo.materialsimpletry.activity.base.ToolbarActivity;
import com.r0adkll.slidr.Slidr;

import butterknife.InjectView;


public class SelectColorActivity extends ToolbarActivity {

    public static final int SELECT_COLOR_SUCCESS = 2333;

    @InjectView(R.id.fab)
    com.melnykov.fab.FloatingActionButton floatingActionButton;

    @InjectView(R.id.overrideSwitch)
    SwitchCompat mOverrideSwitch;

    @InjectView(R.id.primary_seekbar)
    SeekBar mPrimarySeekbar;

    @InjectView(R.id.accent_seekbar)
    SeekBar mAccentSeekbar;

    @InjectView(R.id.primary_preview)
    View mPrimaryPreview;

    @InjectView(R.id.accent_preview)
    View mAccentPreview;

    @InjectView(R.id.lightToggle)
    ToggleButton mLightToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_color);
        initToolbar("设置主题", true);

        Slidr.attach(this);

        // 成功设置主题
        final ColorOverrider overrider = ColorOverrider.getInstance(this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overrider.setEnabled(mOverrideSwitch.isChecked());
                overrider.setAccentHue(mAccentSeekbar.getProgress());
                overrider.setPrimaryHue(mPrimarySeekbar.getProgress());
                setResult(SELECT_COLOR_SUCCESS);
                finish();
            }
        });

        // 自定义主题
        mOverrideSwitch.setChecked(overrider.isEnabled());
        mOverrideSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setComponentsEnable(isChecked, overrider);
            }
        });

        // 选择颜色
        mPrimarySeekbar.setProgress((int) overrider.getPrimaryHue());
        mPrimarySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color = ColorUtils.replaceHue(overrider.getColorPrimary(), progress);
                mPrimaryPreview.setBackgroundColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        mAccentSeekbar.setProgress((int) overrider.getAccentHue());
        mAccentSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int color = ColorUtils.replaceHue(overrider.getColorAccent(), progress);
                mAccentPreview.setBackgroundColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //
        mLightToggle.setChecked(overrider.isLightTheme());
        mLightToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                overrider.setLightTheme(isChecked);
                setComponentsEnable(mOverrideSwitch.isEnabled(), overrider);
            }
        });
        setComponentsEnable(overrider.isEnabled(), overrider);
    }

    private void setComponentsEnable(boolean enabled, ColorOverrider overrider) {
        mPrimarySeekbar.setEnabled(enabled);
        mAccentSeekbar.setEnabled(enabled);
        mLightToggle.setEnabled(enabled);

        int primaryColor = ColorUtils.replaceHue(overrider.getColorPrimary(), mPrimarySeekbar.getProgress());
        mPrimaryPreview.setBackgroundColor(enabled ? primaryColor : Color.DKGRAY);
        int accentColor = ColorUtils.replaceHue(overrider.getColorAccent(), mAccentSeekbar.getProgress());
        mAccentPreview.setBackgroundColor(enabled ? accentColor : Color.GRAY);
    }

}
