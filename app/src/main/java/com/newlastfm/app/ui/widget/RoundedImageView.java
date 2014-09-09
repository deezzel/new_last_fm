package com.newlastfm.app.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.newlastfm.app.Utils;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/12/14.
 */
public class RoundedImageView extends ImageView {
    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int maxWidth = getWidth();
        int maxHeight = getHeight();

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        if (getWidth() > maxWidth && getHeight() > maxHeight) {
            bitmap = Bitmap.createScaledBitmap(bitmap, maxWidth, maxHeight, false);
        }

        int w = getWidth(), h = getHeight();
        if (w > maxWidth) {
            w = maxWidth;
        }
        if (h > maxHeight) {
            h = maxHeight;
        }

        Bitmap roundBitmap = Utils.getRoundedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);

    }

}
