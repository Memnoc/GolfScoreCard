package com.smartdroidesign.golfscorecard.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.smartdroidesign.golfscorecard.Model.Hole;
import com.smartdroidesign.golfscorecard.R;

public class ListAdapter extends BaseAdapter {

    // Creating variables for Context and the object -> best practice
    private final Context mContext;
    private final Hole[] mHoles;

    // Initialize the variables in the constructor
    public ListAdapter (Context context, Hole[]holes) {
        mContext = context;
        mHoles = holes;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // Not implemented
    }

    // Get view needs a ViewHolder to be implemented
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.holeLabel =  convertView.findViewById(R.id.hole_label);
            holder.strokeCount = convertView.findViewById(R.id.strokeCount);
            holder.removeStrokeButton = convertView.findViewById(R.id.removeStrokeButton);
            holder.addStrokeButton = convertView.findViewById(R.id.addStrokeButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.holeLabel.setText(mHoles[position].getLabel());
        holder.strokeCount.setText(String.valueOf(mHoles[position].getStrokeCount()));
        holder.removeStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getStrokeCount() - 1;
                if (updatedStrokeCount <0) updatedStrokeCount = 0;
                mHoles[position].setStrokeCount(updatedStrokeCount);
                holder.strokeCount.setText(String.format("%s", updatedStrokeCount));
            }
        });
        holder.addStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getStrokeCount() + 1;
                mHoles[position].setStrokeCount(updatedStrokeCount);
                holder.strokeCount.setText(String.valueOf(updatedStrokeCount));
            }
        });

        return convertView;
    }




    // ViewHolder implementation
    // This is a class that hold Views, so the oly thing you need
    // are variables to hold the views from list_item.xml
    private static class ViewHolder {
        TextView holeLabel;
        TextView strokeCount;
        Button removeStrokeButton;
        Button addStrokeButton;
    }
}
