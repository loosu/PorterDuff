package com.loosu.porterduff;

import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loosu.porterduff.adapter.ImageViewAdapter;
import com.loosu.porterduff.adapter.PorterDuffDrawableAdapter;
import com.loosu.porterduff.adapter.PorterDuffViewAdapter;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerHolder;
import com.loosu.porterduff.adapter.base.recyclerview.ARecyclerViewAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<PorterDuff.Mode> modes = Arrays.asList(
            PorterDuff.Mode.CLEAR,
            PorterDuff.Mode.SRC,
            PorterDuff.Mode.DST,
            PorterDuff.Mode.SRC_OVER,
            PorterDuff.Mode.DST_OVER,
            PorterDuff.Mode.SRC_IN,
            PorterDuff.Mode.DST_IN,
            PorterDuff.Mode.SRC_OUT,
            PorterDuff.Mode.DST_OUT,
            PorterDuff.Mode.SRC_ATOP,
            PorterDuff.Mode.DST_ATOP,
            PorterDuff.Mode.XOR,
            PorterDuff.Mode.DARKEN,
            PorterDuff.Mode.LIGHTEN,
            PorterDuff.Mode.MULTIPLY,
            PorterDuff.Mode.SCREEN);

    private RecyclerView viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView(savedInstanceState);
        initView(savedInstanceState);
    }

    private void findView(Bundle savedInstanceState) {
        viewList = findViewById(R.id.view_list);
    }

    private void initView(Bundle savedInstanceState) {
        viewList.setLayoutManager(new GridLayoutManager(this, 4));
        //viewList.setAdapter(new PorterDuffViewAdapter(modes));
        //viewList.setAdapter(new PorterDuffDrawableAdapter(modes));
        viewList.setAdapter(new ImageViewAdapter(modes));
    }
}