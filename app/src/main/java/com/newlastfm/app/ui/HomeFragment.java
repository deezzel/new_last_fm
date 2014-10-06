package com.newlastfm.app.ui;


import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newlastfm.app.AppContext;
import com.newlastfm.app.Constants;
import com.newlastfm.app.R;
import com.newlastfm.app.Utils;
import com.newlastfm.app.ui.gridview.RecommendedArtistsListAdapter;
import com.newlastfm.app.ui.widget.RoundedImageView;
import com.newlastfm.model.RecommendedArtists;
import com.nostra13.universalimageloader.core.ImageLoader;

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
    //    @ViewById(R.id.recommendations)
//    GridView recommendationsGridView;
    @ViewById(R.id.recommendationsLayout)
    LinearLayout recommendations;
    RecommendedArtists recommendedArtists;
    List<RecommendedArtists.ParentArtist> artists = new ArrayList<RecommendedArtists.ParentArtist>();
    String apiSigRecommendedArtists;
    RecommendedArtistsListAdapter recommendedArtistsListAdapter;
    ImageLoader imageLoader;

    public HomeFragment() {

    }

    @AfterViews
    void init() {
        imageLoader = Utils.initImageLoader(getActivity().getApplicationContext(), imageLoader);
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
        List<RecommendedArtists.ParentArtist> tmp1 = new ArrayList<RecommendedArtists.ParentArtist>();
        List<RecommendedArtists.ParentArtist> tmp2 = new ArrayList<RecommendedArtists.ParentArtist>();
        tmp1.add(artists.get(0));
        tmp1.add(artists.get(1));
        tmp2.add(artists.get(2));
        tmp2.add(artists.get(3));
        recommendations.addView(formLine(tmp1));
        recommendations.addView(formLine(tmp2));
//        recommendedArtistsListAdapter = new RecommendedArtistsListAdapter(getActivity(), artists);
//        recommendationsGridView.setAdapter(recommendedArtistsListAdapter);
    }

    LinearLayout formLine(List<RecommendedArtists.ParentArtist> parentArtists) {
        LinearLayout linearLayout = new LinearLayout(getActivity().getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        for (RecommendedArtists.ParentArtist artist : parentArtists) {
            linearLayout.addView(formItem(artist));
        }
        return linearLayout;
    }

    View formItem(RecommendedArtists.ParentArtist artist) {
        LayoutInflater mInflater = (LayoutInflater) getActivity().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View convertView = mInflater.inflate(R.layout.recommendations_grid_item, null);

        ImageView imageCover = (ImageView) convertView.findViewById(R.id.imageCover);
        TextView artistName = (TextView) convertView.findViewById(R.id.artistName);
        TextView similarArtists = (TextView) convertView.findViewById(R.id.similarArtists);
        RoundedImageView similarArtistCover1 = (RoundedImageView) convertView.findViewById(R.id.similarArtistCover1);
        RoundedImageView similarArtistCover2 = (RoundedImageView) convertView.findViewById(R.id.similarArtistCover2);
        ImageView similarArtistCover2Bg = (ImageView) convertView.findViewById(R.id.similarArtistCover2Bg);

        imageLoader.displayImage(artist.getImage().get(3).getText(), imageCover);
        artistName.setText(artist.getName());
        String similar = "Similar with ";
        for (int i = 0; i < artist.getContext().getArtists().size(); i++) {
            RecommendedArtists.Artist a = artist.getContext().getArtists().get(i);
            similar = similar + a.getName();
            if (i < artist.getContext().getArtists().size() - 1) {
                similar = similar + " and ";
            }
        }
        similarArtists.setText(similar);
        if (artist.getContext().getArtists().size() > 1) {
            imageLoader.displayImage(artist.getContext().getArtists().get(0).getImage().get(2).getText(), similarArtistCover1);
            imageLoader.displayImage(artist.getContext().getArtists().get(1).getImage().get(2).getText(), similarArtistCover2);
        } else if (artist.getContext().getArtists().size() == 0) {
            imageLoader.displayImage(artist.getContext().getArtist().getImage().get(2).getText(), similarArtistCover1);
            similarArtistCover2.setVisibility(View.INVISIBLE);
            similarArtistCover2Bg.setVisibility(View.INVISIBLE);
        }

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = .5f;
        convertView.setLayoutParams(layoutParams);
        return convertView;
    }
}
