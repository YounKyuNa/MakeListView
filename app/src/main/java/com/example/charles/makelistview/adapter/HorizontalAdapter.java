package com.example.charles.makelistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.charles.makelistview.model.Popular;

import java.util.List;

/**
 * Created by charles on 2017. 10. 27..
 * Horizontal Adapter
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder> {

    private Context context;
    private List<Popular> popularList;

    public HorizontalAdapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CustomViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
