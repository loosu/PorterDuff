package com.loosu.porterduff.adapter.base.recyclerview;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class RecyclerViewHelper {
    private RecyclerViewHelper() {
        throw new RuntimeException("this class can not instance!!");
    }

    /**
     * 查找并返回当前view最接近的{@link RecyclerView}
     */
    @Nullable
    public static RecyclerView findParentRecyclerView(@Nullable View view) {
        if (view == null) {
            return null;
        }

        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return findParentRecyclerView((ViewGroup) parent);
            } else {
                return null;
            }
        }
    }
}
