package com.ivo.materialsimpletry.mycode;

import app.mosn.zdepthshadowlayout.ZDepth;


public class ToolbarShadowHelper {

    public static final ZDepth[] ZDEPTHS = {ZDepth.Depth0, ZDepth.Depth1, ZDepth.Depth2, ZDepth.Depth3};

    private static int depth = 1;

    public static void setDepth(int depth) {
        ToolbarShadowHelper.depth = depth;
    }

    public static int getDepth() {
        return depth;
    }

    public static ZDepth getZDepth() {

        return ZDEPTHS[depth];
    }

}
