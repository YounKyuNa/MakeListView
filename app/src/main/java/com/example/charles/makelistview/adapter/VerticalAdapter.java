package com.example.charles.makelistview.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charles.makelistview.R;
import com.example.charles.makelistview.helper.CircleTransform;
import com.example.charles.makelistview.model.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by charles on 2017. 10. 27..
 * Vertical Adapter
 */

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.CustomViewHolder> {

    private Context context;
    private List<Datum> dataList;

    public VerticalAdapter(Context context, List<Datum> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_single_item, null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Datum datum = dataList.get(position);

        Picasso.with(context)
                .load(datum.getImage())
                .into(holder.fullImage);

        holder.nameTextView.setText(datum.getTitle());

        Picasso.with(context)
                .load(datum.getNameImage())
                .transform(new CircleTransform())
                .into(holder.profileImage);

        holder.profileName.setText(datum.getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView fullImage;
        ImageView profileImage;
        TextView nameTextView, profileName, timeStamp;
        CardView cardView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.name_text_view);
            profileName = itemView.findViewById(R.id.profile_name);
            timeStamp = itemView.findViewById(R.id.time_stamp);
            fullImage = itemView.findViewById(R.id.full_image);
            profileImage = itemView.findViewById(R.id.profile_image);
            cardView = itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
