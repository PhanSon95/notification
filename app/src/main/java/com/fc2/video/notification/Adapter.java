package com.fc2.video.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context mContext;
    private int mLayout;
    private List<Notification> mList;

    public Adapter(Context context, int layout, List<Notification> list) {
        this.mContext = context;
        this.mLayout = layout;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.notification, viewGroup, false);
        }

        // get current item to be displayed
        Notification currentItem = (Notification) getItem(i);

        // get the TextView for item name and item description
        TextView packageName = (TextView)
                view.findViewById(R.id.packageName);
        TextView title = (TextView)
                view.findViewById(R.id.title);
        TextView body = (TextView)
                view.findViewById(R.id.body);

        //sets the text for item name and item description from the current item object
        packageName.setText(currentItem.getPackageName());
        title.setText(currentItem.getTitle());
        body.setText(currentItem.getBody());

        // returns the view for the current row
        return view;
    }
}
