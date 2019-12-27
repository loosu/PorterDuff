package com.loosu.porterduff;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PorterDuffView extends View {
    private final Paint paint = new Paint();

    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);

    public PorterDuffView(Context context) {
        super(context);
    }

    public PorterDuffView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMode(PorterDuff.Mode mode) {
        xfermode = new PorterDuffXfermode(mode);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int width = getWidth();
        final int height = getHeight();

        int size = Math.min(width, height) * 2 / 3;
        Context context = getContext();
        Resources res = context.getResources();

        // dest
        int ovalLeft = 0;
        int ovalTop = 0;
        int ovalRight = size;
        int ovalBottom = size;
        paint.setColor(0x55ffff66);
        canvas.drawArc(ovalLeft, ovalTop, ovalRight, ovalBottom, 0, 360, true, paint);

        // src
        int rectLeft = width - size;
        int rectTop = height - size;
        int rectRight = width;
        int rectBottom = height;
        paint.setColor(0x556666ff);
        paint.setXfermode(xfermode);
        canvas.drawRect(rectLeft, rectTop, rectRight, rectBottom, paint);
        paint.setXfermode(null);
    }
}
