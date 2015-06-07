package com.ivo.materialsimpletry.mycode;

import android.content.Context;
import android.util.AttributeSet;

import app.mosn.zdepthshadowlayout.ZDepthShadowLayout;


public class ToolbarShadowLayout extends ZDepthShadowLayout {

    public ToolbarShadowLayout(Context context) {
        super(context);
    }

    public ToolbarShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToolbarShadowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {

        setZDepthBeforeAttachedToWindow(ToolbarShadowHelper.getDepth());
        super.onAttachedToWindow();
    }
}
