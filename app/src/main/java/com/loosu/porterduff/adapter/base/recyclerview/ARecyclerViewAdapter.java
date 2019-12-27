package com.loosu.porterduff.adapter.base.recyclerview;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class ARecyclerViewAdapter<T> extends AbsRecyclerViewAdapter<ARecyclerHolder> {
    private List<T> datas = null;

    public ARecyclerViewAdapter(List<T> datas) {
        if (datas == null) {
            this.datas = new ArrayList<>();
        } else {
            this.datas = datas;
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 返回条目对应的数据
     */
    @NonNull
    public T getItem(int position) {
        return datas.get(position);
    }
}
