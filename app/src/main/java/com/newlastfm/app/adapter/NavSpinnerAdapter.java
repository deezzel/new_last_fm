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
import com.newlastfm.app.ui.drawer.NavSpinnerItem;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/15/14.
 */
public class NavSpinnerAdapter extends ArrayAdapter<NavSpinnerItem> {

    Context context;
    int layoutResID;
    ImageView userImage;
    TextView  name,email;
    List<NavSpinnerItem> spinnerData;

    public NavSpinnerAdapter(Context context, int layoutResourceID,
                                int textViewResourceId, List<NavSpinnerItem> spinnerDataList) {
        super(context, layoutResourceID, textViewResourceId, spinnerDataList);

        this.context=context;
        this.layoutResID=layoutResourceID;
        this.spinnerData=spinnerDataList;

    }



    public NavSpinnerAdapter(Context context, int layoutResourceID,
                                List<NavSpinnerItem> spinnerDataList) {
        super(context, layoutResourceID, spinnerDataList);

        this.context=context;
        this.layoutResID=layoutResourceID;
        this.spinnerData=spinnerDataList;

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
            row = inflater.inflate(R.layout.custom_spinner_item, null);

            userImage=(ImageView)row.findViewById(R.id.left_pic);
            name=(TextView)row.findViewById(R.id.text_main_name);
            email=(TextView)row.findViewById(R.id.sub_text_email);
        }


        NavSpinnerItem spinnerItem=spinnerData.get(position);

        userImage.setImageDrawable(row.getResources().getDrawable(spinnerItem.getDrawableResID()));
        name.setText(spinnerItem.getName());
        email.setText(spinnerItem.getEmail());

        return row;

    }
}
