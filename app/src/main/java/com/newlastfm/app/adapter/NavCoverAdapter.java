package com.newlastfm.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.newlastfm.app.R;
import com.newlastfm.app.ui.drawer.NavCoverItem;
import com.newlastfm.app.ui.drawer.NavSpinnerItem;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/18/14.
 */
public class NavCoverAdapter extends ArrayAdapter<NavCoverItem> {
    Context context;
    int layoutResID;
    ImageView userAvatar;
    TextView fullName;
    List<NavCoverItem> coverItems;

    public NavCoverAdapter(Context context, int layoutResourceID,
                             int textViewResourceId, List<NavCoverItem> coverItems) {
        super(context, layoutResourceID, textViewResourceId, coverItems);

        this.context=context;
        this.layoutResID=layoutResourceID;
        this.coverItems=coverItems;
    }
    public NavCoverAdapter(Context context, int layoutResourceID,
                             List<NavCoverItem> coverItems) {
        super(context, layoutResourceID, coverItems);

        this.context=context;
        this.layoutResID=layoutResourceID;
        this.coverItems=coverItems;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row=convertView;

        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_cover_item, null);

            userAvatar=(ImageView)row.findViewById(R.id.userAvatar);
            fullName=(TextView)row.findViewById(R.id.userFullName);
        }


        NavCoverItem coverItem=coverItems.get(position);

        userAvatar.setImageDrawable(row.getResources().getDrawable(coverItem.getDrawableResID()));
        fullName.setText(coverItem.getFullName());

        return row;

    }

}
