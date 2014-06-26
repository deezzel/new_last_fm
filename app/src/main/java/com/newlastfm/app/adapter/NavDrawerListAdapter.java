package com.newlastfm.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.newlastfm.app.R;
import com.newlastfm.app.ui.drawer.NavCoverItem;
import com.newlastfm.app.ui.drawer.NavDrawerItem;
import com.newlastfm.app.ui.drawer.NavSpinnerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 6/13/14.
 */
public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
        Spinner drawerSpinner = (Spinner) convertView.findViewById(R.id.drawerSpinner);
        TextView drawerTitle = (TextView) convertView.findViewById(R.id.drawerTitle);
        ImageView userAvatar = (ImageView) convertView.findViewById(R.id.userAvatar);
        TextView userFullName = (TextView) convertView.findViewById(R.id.userFullName);
        LinearLayout coverContent = (LinearLayout) convertView.findViewById(R.id.profileContent);
        LinearLayout spinnerLayout = (LinearLayout) convertView.findViewById(R.id.spinnerLayout);
        LinearLayout headerLayout = (LinearLayout) convertView.findViewById(R.id.headerLayout);
        LinearLayout itemLayout = (LinearLayout) convertView.findViewById(R.id.itemLayout);
        RelativeLayout coverLayout = (RelativeLayout) convertView.findViewById(R.id.profileLayout);

        if (navDrawerItems.get(position).isCover()){
            headerLayout.setVisibility(View.INVISIBLE);
            itemLayout.setVisibility(View.INVISIBLE);
            spinnerLayout.setVisibility(View.INVISIBLE);
            coverLayout.setVisibility(View.VISIBLE);
            List<NavCoverItem> coverItems = new ArrayList<NavCoverItem>();
            coverItems.add(new NavCoverItem(R.drawable.user1, "Artem Mykhelson"));
            NavCoverAdapter coverAdapter = new NavCoverAdapter(context,R.layout.custom_cover_item,coverItems);
            
            userAvatar.setImageResource(navDrawerItems.get(position).getUserAvatar());
            userFullName.setText(navDrawerItems.get(position).getFullName());
        } else if (navDrawerItems.get(position).isSpinner()){
            headerLayout.setVisibility(View.INVISIBLE);
            itemLayout.setVisibility(View.INVISIBLE);
            coverLayout.setVisibility(View.INVISIBLE);
            spinnerLayout.setVisibility(View.VISIBLE);
            List<NavSpinnerItem> usersList = new ArrayList<NavSpinnerItem>();
            usersList.add(new NavSpinnerItem(R.drawable.user1,"Artem Mykhelsom", "artem.mykhelson@gmail.com"));
//            usersList.add(new NavSpinnerItem(R.drawable.user2,"Artem Mihelson", "artem.mihelson@gmail.com"));
            NavSpinnerAdapter spinnerAdapter = new NavSpinnerAdapter(context, R.layout.custom_spinner_item,usersList);
            drawerSpinner.setAdapter(spinnerAdapter);
            drawerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                int count=0;
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (count >= 1) {
                        Toast.makeText(context, "User Changed",
                                Toast.LENGTH_SHORT).show();
                    }
                    count++;
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } else if (navDrawerItems.get(position).getDrawerTitle() != null){
            headerLayout.setVisibility(View.VISIBLE);
            spinnerLayout.setVisibility(View.INVISIBLE);
            itemLayout.setVisibility(View.INVISIBLE);
            coverLayout.setVisibility(View.INVISIBLE);
            drawerTitle.setText(navDrawerItems.get(position).getDrawerTitle());
        } else {
            headerLayout.setVisibility(View.INVISIBLE);
            spinnerLayout.setVisibility(View.INVISIBLE);
            coverLayout.setVisibility(View.INVISIBLE);
            itemLayout.setVisibility(View.VISIBLE);
            imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
            txtTitle.setText(navDrawerItems.get(position).getTitle());

            // displaying count
            // check whether it set visible or not
            if (navDrawerItems.get(position).getCounterVisibility()) {
                txtCount.setText(navDrawerItems.get(position).getCount());
            } else {
                // hide the counter view
                txtCount.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

}
