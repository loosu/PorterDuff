package com.loosu.porterduff.adapter;

import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loosu.porterduff.PorterDuffView;
import com.loosu.porterduff.R;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerHolder;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerViewAdapter;

import java.util.List;

public class PorterDuffViewAdapter extends ARecyclerViewAdapter<PorterDuff.Mode> {

    public PorterDuffViewAdapter(List<PorterDuff.Mode> datas) {
        super(datas);
    }

    @NonNull
    @Override
    protected ARecyclerHolder getViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sample, null, false);
        return new ARecyclerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ARecyclerHolder holder, int i) {
        final PorterDuff.Mode mode = getItem(i);

        PorterDuffView porterDuffView = holder.findViewById(R.id.porter_view);
        porterDuffView.setMode(mode);
        holder.setText(R.id.tv_text, mode.toString());
    }
}