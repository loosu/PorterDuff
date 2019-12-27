package com.loosu.porterduff.adapter.base.recyclerview;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ARecyclerHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views = new SparseArray<>();

    public ARecyclerHolder(View itemView) {
        super(itemView);
    }

    /**
     * 查找 holder 中的 view
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置集成了{@link TextView}的文办
     */
    public ARecyclerHolder setText(int viewId, CharSequence text) {
        ((TextView) findViewById(viewId)).setText(text);
        return this;
    }

    public ARecyclerHolder setImageResource(int viewId, @DrawableRes int resId){
        ((ImageView)findViewById(viewId)).setImageResource(resId);
        return this;
    }
}
