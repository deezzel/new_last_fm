package com.newlastfm.model.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.newlastfm.model.Artist;
import com.newlastfm.model.Image;
import com.newlastfm.model.RecommendedArtists;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 10/5/14.
 */
public class RecommendedArtistsDeserializer implements JsonDeserializer<RecommendedArtists> {
    @Override
    public RecommendedArtists deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext deserializationContext) throws
            JsonParseException {
        final RecommendedArtists recommendedArtists = new RecommendedArtists();
        final RecommendedArtists.RecommendationsInfo recommendationsInfo = new RecommendedArtists.RecommendationsInfo();
        final List<RecommendedArtists.ParentArtist> parentArtistList = new ArrayList<RecommendedArtists.ParentArtist>();
        final JsonObject jsonObject = json.getAsJsonObject();
        RecommendedArtists.Attributes attributes = deserializationContext.deserialize(jsonObject.get("@attr"),
                RecommendedArtists.Attributes.class);

        JsonObject recommendations = jsonObject.getAsJsonObject("recommendations");
        JsonArray parentArtists = recommendations.getAsJsonArray("artist");
        for (JsonElement parentArtist : parentArtists) {
            JsonObject parent = parentArtist.getAsJsonObject();
            RecommendedArtists.ParentArtist artistParent = new RecommendedArtists.ParentArtist();
            artistParent.setName(parent.get("name").getAsString());
            artistParent.setMbid(parent.get("mbid").getAsString());
            artistParent.setUrl(parent.get("url").getAsString());
            artistParent.setStreamable(parent.get("streamable").getAsInt());
            Image[] images = deserializationContext.deserialize(parent.get("image").getAsJsonArray(), Image[].class);
            artistParent.setImage(Arrays.asList(images));
            RecommendedArtists.Context artists_context = new RecommendedArtists.Context();
            JsonObject context = parent.get("context").getAsJsonObject();
            JsonElement artist = context.get("artist");
            if (artist.isJsonArray()) {
                Artist[] artists = deserializationContext.deserialize(artist,
                        Artist[].class);
                artists_context.setArtists(Arrays.asList(artists));
            } else if (artist.isJsonObject()) {
                Artist derived_artist = deserializationContext.deserialize(artist,
                        Artist.class);
                artists_context.setArtist(derived_artist);
            }
            artistParent.setContext(artists_context);
            parentArtistList.add(artistParent);
        }
        recommendationsInfo.setArtist(parentArtistList);
        recommendedArtists.setRecommendations(recommendationsInfo);
        recommendedArtists.setAttr(attributes);
        return recommendedArtists;
    }
}
