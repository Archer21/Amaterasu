package com.archer.amaterasu.io.deserializer;

import android.util.SparseArray;

import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.io.ApiConstants;
import com.archer.amaterasu.io.model.SongKeys;
import com.archer.amaterasu.io.model.SongResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by archer on 20-12-16.
 */

public class SongDeserializer implements JsonDeserializer<SongResponse> {
    @Override
    public SongResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SongResponse response = gson.fromJson(json, SongResponse.class);

        JsonObject songResponse = json.getAsJsonObject().getAsJsonObject(SongKeys.SONGS_RESULTS);
        JsonArray  songsArray   = songResponse.getAsJsonArray(SongKeys.SONGS_ARRAY);

        response.setSongs(extractSongsFromJsonArray(songsArray));

        return response;
    }

    private List<Song> extractSongsFromJsonArray (JsonArray jsonArray) {
        List<Song> songs = new ArrayList<>();
        int size = jsonArray.size();

        for (int i = 0; i < size; i++) {
            Song currentSong = new Song();

            JsonObject songData = jsonArray.get(i).getAsJsonObject();
            int    id       = songData.get(SongKeys.SONG_ID).getAsInt();
            String title    = songData.get(SongKeys.SONG_TITLE).getAsString();
            String artist   = songData.get(SongKeys.SONG_ARTIST).getAsString();
            int    likes    = songData.get(SongKeys.SONG_LIKES).getAsInt();
            String duration = songData.get(SongKeys.SONG_DURATION).getAsString();
            float  rating   = songData.get(SongKeys.SONG_RATING).getAsFloat();
            String year     = songData.get(SongKeys.SONG_YEAR).getAsString();

            JsonArray imagesArray = songData.get(SongKeys.SONG_IMAGES).getAsJsonArray();
            SparseArray<String> images = extractImagesFromJsonArray(imagesArray);

            currentSong.setId(id);
            currentSong.setTitle(title);
            currentSong.setArtist(artist);
            currentSong.setLikes(likes);
            currentSong.setDuration(duration);
            currentSong.setRating(rating);
            currentSong.setYear(year);
            currentSong.setImages(images);

            songs.add(currentSong);
        }

        return songs;
    }

    private SparseArray<String> extractImagesFromJsonArray (JsonArray jsonArray) {
        SparseArray<String> images = new SparseArray<>();
        int size = jsonArray.size();

        for (int i = 0; i < size; i++) {
            JsonObject imagesData = jsonArray.get(i).getAsJsonObject();
            String imageSmall  = imagesData.get(SongKeys.SONG_IMAGE_SMALL).getAsString();
            String imageMedium = imagesData.get(SongKeys.SONG_IMAGE_MEDIUM).getAsString();
            images.put(0, imageSmall);
            images.put(1, imageMedium);
        }
        return images;
    }

}




































