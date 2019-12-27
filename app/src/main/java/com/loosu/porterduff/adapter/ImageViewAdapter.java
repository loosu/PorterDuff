package com.loosu.porterduff.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.loosu.porterduff.PorterDuffView;
import com.loosu.porterduff.R;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerHolder;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerViewAdapter;

import java.util.List;

public class ImageViewAdapter extends ARecyclerViewAdapter<PorterDuff.Mode> {

    public ImageViewAdapter(List<PorterDuff.Mode> datas) {
        super(datas);
    }

    @NonNull
    @Override
    protected ARecyclerHolder getViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, null, false);
        return new ARecyclerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ARecyclerHolder holder, int i) {
        final PorterDuff.Mode mode = getItem(i);

        Resources res = holder.itemView.getResources();
        Bitmap desBmp = BitmapFactory.decodeResource(res, R.drawable.ic_des).copy(Bitmap.Config.ARGB_8888, true);
        Bitmap srcBmp = BitmapFactory.decodeResource(res, R.drawable.ic_src);

        Paint paint = new Paint();
        Canvas canvas = new Canvas(desBmp);
        paint.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawBitmap(srcBmp, 0,0, paint);

        final ImageView ivImage = holder.findViewById(R.id.iv_image);
        ivImage.setImageBitmap(desBmp);

        holder.setText(R.id.tv_text, mode.toString());
    }
}