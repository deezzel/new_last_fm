package com.newlastfm.app.ui.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.newlastfm.app.R;
import com.newlastfm.app.ui.widget.RoundedImageView;
import com.newlastfm.model.Artist;
import com.newlastfm.model.RecommendedArtists.ParentArtist;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/15/14.
 */
public class RecommendedArtistsListAdapter extends ArrayAdapter<ParentArtist> {

    static final String imageUrl = "https://ws.audioscrobbler.com/2.0/";
    static ImageLoader imageLoader;
    private static Context context;
    List<ParentArtist> recommendedArtists;

    public RecommendedArtistsListAdapter(Context context, List<ParentArtist> recommendedArtists) {
        super(context, R.layout.recommendations_grid_item, recommendedArtists);

        this.context = context;
        this.recommendedArtists = recommendedArtists;

        DisplayImageOptions displayDefaultImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(context)
                .diskCacheSize(50 * 1024 * 1024) //50Mb
                .defaultDisplayImageOptions(displayDefaultImageOptions)
                .build();
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(imageLoaderConfiguration);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ParentArtist artist = getItem(position);

        ArtistsViewHolder holder;
        if (convertView == null) {
            convertView = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = li.inflate(R.layout.recommendations_grid_item, parent, false);

            holder = new ArtistsViewHolder();
            holder.imageCover = (ImageView) convertView.findViewById(R.id.imageCover);
            holder.artistName = (TextView) convertView.findViewById(R.id.artistName);
            holder.similarArtists = (TextView) convertView.findViewById(R.id.similarArtists);
            holder.similarArtistCover1 = (RoundedImageView) convertView.findViewById(R.id.similarArtistCover1);
            holder.similarArtistCover2 = (RoundedImageView) convertView.findViewById(R.id.similarArtistCover2);
            holder.similarArtistCover2Bg = (ImageView) convertView.findViewById(R.id.similarArtistCover2Bg);

            convertView.setTag(holder);
        } else {
            holder = (ArtistsViewHolder) convertView.getTag();
        }

        holder.populate(artist);
        return convertView;
    }

    static class ArtistsViewHolder {
        public ImageView imageCover;
        public TextView artistName;
        public TextView similarArtists;
        public RoundedImageView similarArtistCover1;
        public RoundedImageView similarArtistCover2;
        public ImageView similarArtistCover2Bg;

        void populate(ParentArtist artist) {
            imageLoader.displayImage(artist.getImage().get(3).getText(), imageCover);
            artistName.setText(artist.getName());
            String similar = "Similar with ";
            for (int i = 0; i < artist.getContext().getArtists().size(); i++) {
                Artist a = artist.getContext().getArtists().get(i);
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
        }
    }
}
