package com.xishuang.imagesizetest.colorfilter;

/**
 * Created by xishuang on 2018/2/5.
 */

public class SpecialMatrix {
    private static final float[] COMMON = new float[]{
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0
    };

    private static final float[] HUAIJIU = new float[]{
            0.393f, 0.769f, 0.189f, 0, 0,
            0.349f, 0.686f, 0.168f, 0, 0,
            0.272f, 0.534f, 0.131f, 0, 0,
            0, 0, 0, 1, 0
    };

    private static final float[] DIPIAN = new float[]{
            -1, 0, 0, 0, 255,
            0, -1, 0, 0, 255,
            0, 0, -1, 0, 255,
            0, 0, 0, 1, 0
    };

    public static float[] getHuaiJiu() {
        return HUAIJIU.clone();
    }
    public static float[] getDiPian() {
        return DIPIAN.clone();
    }
}
