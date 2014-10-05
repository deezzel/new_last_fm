package com.newlastfm.app.ui;


import android.app.Fragment;
import android.widget.GridView;

import com.newlastfm.app.AppContext;
import com.newlastfm.app.Constants;
import com.newlastfm.app.R;
import com.newlastfm.app.Utils;
import com.newlastfm.app.ui.gridview.RecommendedArtistsListAdapter;
import com.newlastfm.model.RecommendedArtists;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @Bean
    AppContext ctx;
    @ViewById(R.id.recommendations)
    GridView recommendationsGridView;
    RecommendedArtists recommendedArtists;
    List<RecommendedArtists.ParentArtist> artists = new ArrayList<RecommendedArtists.ParentArtist>();
    String apiSigRecommendedArtists;
    RecommendedArtistsListAdapter recommendedArtistsListAdapter;

    public HomeFragment() {

    }

    @AfterViews
    void init() {
        getRecommendedArtists();
    }

    @Background
    void getRecommendedArtists() {
        apiSigRecommendedArtists = Utils.buildApiSig(Constants.apiKey, "user.getRecommendedArtists",
                ctx.storage.getUser().sk, Constants.secret, "1", "50");
        String params = "api_sig=" + apiSigRecommendedArtists + "&api_key=" + Constants.apiKey + "&method=user.getRecommendedArtists" +
                "&sk=" + ctx.storage.getUser().sk + "&page=1&limit=50" + "&format=json";
        recommendedArtists = ctx.api.getRecommendedArtists(params);
        initViews();
    }

    @UiThread
    void initViews() {
        List<RecommendedArtists.ParentArtist> parentArtists = recommendedArtists.getRecommendations().getArtist();
        Collections.shuffle(parentArtists);
        for (int i = 0; i < 4; i++) {
            artists.add(parentArtists.get(i));
        }
        recommendedArtistsListAdapter = new RecommendedArtistsListAdapter(getActivity(), artists);
        recommendationsGridView.setAdapter(recommendedArtistsListAdapter);
    }
}
