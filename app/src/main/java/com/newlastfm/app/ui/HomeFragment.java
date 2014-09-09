package com.newlastfm.app.ui;


import android.app.Fragment;
import android.widget.GridView;

import com.newlastfm.app.AppContext;
import com.newlastfm.app.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    String apiSig;
    @Bean
    AppContext ctx;
    @ViewById(R.id.recommendations)
    GridView recommendationsGridView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @AfterViews
    void init() {

    }
}
