package com.ivo.materialsimpletry.mycode;

public class ToolbarShadowHelper {

    private static int depth = 1;

    public static void setDepth(int depth) {
        ToolbarShadowHelper.depth = depth;
    }

    public static int getDepth() {
        return depth;
    }

}
