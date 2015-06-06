package com.ivo.materialsimpletry.mycode;

import android.content.Context;
import android.util.AttributeSet;

import app.mosn.zdepthshadowlayout.ZDepthShadowLayout;


public class ToolbarDepthShadowLayout extends ZDepthShadowLayout {

    public ToolbarDepthShadowLayout(Context context) {
        super(context);
    }

    public ToolbarDepthShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToolbarDepthShadowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        changeZDepth(ToolbarShadowHelper.getZDepth());
    }
}
