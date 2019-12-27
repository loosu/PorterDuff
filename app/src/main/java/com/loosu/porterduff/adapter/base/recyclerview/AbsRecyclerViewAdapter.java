package com.loosu.porterduff.adapter.base.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbsRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private static final String TAG = "AbsRecyclerViewAdapter";

    private ItemClickListener itemClickListener = null;

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH holder = getViewHolder(parent, viewType);
        holder.itemView.setOnClickListener(viewClickListener);
        return holder;
    }

    /**
     * 替代 {@link #onCreateViewHolder(ViewGroup, int)} 方法，创建 view holder.
     */
    @NonNull
    protected abstract VH getViewHolder(ViewGroup parent, int viewType);

    /**
     * 设置条目点击监听
     *
     * @param itemClickListener listener
     */
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /**
     * 条目点击接口
     */
    public static interface ItemClickListener {
        /**
         * 条目点击回调
         *
         * @param parent   所在的{@link RecyclerView}
         * @param holder   {@link RecyclerView.ViewHolder} holder
         * @param position 条目位置
         * @param view     触发点击的view
         */
        public void onItemClick(RecyclerView parent, RecyclerView.ViewHolder holder, int position, View view);
    }

    private final View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                RecyclerView recyclerView = RecyclerViewHelper.findParentRecyclerView(view);
                RecyclerView.ViewHolder holder = recyclerView.findContainingViewHolder(view);

                if (itemClickListener != null) {
                    itemClickListener.onItemClick(recyclerView, holder, holder.getAdapterPosition(), view);
                }
            } catch (Exception exception) {
                // 太多空指针情况了，不处理了直接抓异常
                Log.d(TAG, "", exception);
            }
        }
    };
}