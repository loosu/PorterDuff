package com.loosu.porterduff;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.loosu.alog.ALog;

public class PorterDuffDrawable extends Drawable {
    private static final String TAG = "PorterDuffDrawable";
    private final Paint paint = new Paint();
    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);

    public void setMode(PorterDuff.Mode mode) {
        xfermode = new PorterDuffXfermode(mode);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        final Rect bounds = getBounds();
        ALog.d(TAG, "bounds = " + bounds);

        final int width = bounds.width();
        final int height = bounds.height();

        int size = Math.min(width, height) * 2 / 3;

        // dest
        int ovalLeft = 0;
        int ovalTop = 0;
        int ovalRight = size;
        int ovalBottom = size;
        paint.setColor(Colors.argb(0.8f, 1, 0.5f, 0));
        canvas.drawArc(ovalLeft, ovalTop, ovalRight, ovalBottom, 0, 360, true, paint);

        // src

        int rectLeft = width - size;
        int rectTop = height - size;
        int rectRight = width;
        int rectBottom = height;
        paint.setColor(Colors.argb(0.8f, 0, 0.5f, 1));
        paint.setXfermode(xfermode);
        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);
        paint.setXfermode(null);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
