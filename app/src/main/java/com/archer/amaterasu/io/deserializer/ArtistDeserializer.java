package com.archer.amaterasu.io.deserializer;

import com.archer.amaterasu.domain.Artist;
import com.archer.amaterasu.io.model.ArtistKeys;
import com.archer.amaterasu.io.model.ArtistResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class ArtistDeserializer implements JsonDeserializer<ArtistResponse> {

    @Override
    public ArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ArtistResponse response       = gson.fromJson(json, ArtistResponse.class);
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(ArtistKeys.ARTISTS_RESULTS);
        JsonArray artistArray         = artistResponseData.getAsJsonArray(ArtistKeys.ARTISTS_ARRAY);

        response.setArtists(extractArtistsFromJsonArray(artistArray));
        return response;
    }

    public ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array){
        ArrayList<Artist> artists = new ArrayList<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            Artist currentArtist = new Artist();
            JsonObject artistData = array.get(i).getAsJsonObject();
            String name   = artistData.get(ArtistKeys.ARTIST_NAME).getAsString();
            int    votes  = artistData.get(ArtistKeys.ARTIST_VOTES).getAsInt();
            float  rating = artistData.get(ArtistKeys.ARTIST_RATING).getAsFloat();

            JsonArray imagesArray = artistData.get(ArtistKeys.ARTIST_IMAGES_ARRAY).getAsJsonArray();
            HashMap<Integer, String> artistImages = extractImagesFromJsonArray(imagesArray);

            currentArtist.setName(name);
            currentArtist.setVotes(votes);
            currentArtist.setRating(rating);
            currentArtist.setCover(artistImages.get(0));
            artists.add(currentArtist);
        }
        return artists;
    }

    public HashMap<Integer, String> extractImagesFromJsonArray(JsonArray array){
        HashMap<Integer, String> images = new HashMap<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            JsonObject imagesObject = array.get(i).getAsJsonObject();
            String     cover = imagesObject.get(ArtistKeys.ARTIST_IMAGE_COVER).getAsString();
            String     photo = imagesObject.get(ArtistKeys.ARTIST_IMAGE_PHOTO).getAsString();

            images.put(0, cover);
            images.put(1, photo);
        }
        return images;
    }
}