package com.xishuang.imagesizetest.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Author : xishuang
 * Date   : 2018.04.02
 * Desc   :
 */

public class ImageUtil {

    /**
     * 图片的处理
     *
     * @param res_id 图片的资源id
     */
    public static void displayImage(ImageView imageView, int res_id) {
        imageView.setImageResource(res_id);
        Drawable drawable = imageView.getDrawable();
        float[] targetMatrix = SpecialMatrix.getHuaiJiu();
        if (drawable != null) {
            ColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0x000000);
            imageView.getDrawable().setColorFilter(lightingColorFilter);
//            drawable.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(targetMatrix)));
        }
    }

    public static void displayImageSobel(Context context, ImageView imageView, int res_id) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res_id);
        bitmap = SobelUtils.Sobel(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
