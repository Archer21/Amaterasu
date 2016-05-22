package com.archer.amaterasu.io.deserializer;

import com.archer.amaterasu.domain.Song;
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
import java.util.HashMap;

public class SongDeserializer implements JsonDeserializer<SongResponse>{

    @Override
    public SongResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SongResponse response         = gson.fromJson(json, SongResponse.class);
        JsonObject   songResponseData = json.getAsJsonObject().getAsJsonObject(SongKeys.SONGS_RESULTS);
        JsonArray    songsArray       = songResponseData.getAsJsonArray(SongKeys.SONGS_ARRAY);

        response.setSongs(extractSongsFromJsonArray(songsArray));
        return response;
    }

    public ArrayList<Song> extractSongsFromJsonArray(JsonArray array){
        ArrayList<Song> songs = new ArrayList<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            Song currentSong = new Song();
            JsonObject songData = array.get(i).getAsJsonObject();
            int    id     = songData.get(SongKeys.SONG_ID).getAsInt();
            String title  = songData.get(SongKeys.SONG_TITLE).getAsString();
            String artist = songData.get(SongKeys.SONG_ARTIST).getAsString();
            int    views  = songData.get(SongKeys.SONG_VIEWS).getAsInt();
            float  rating = songData.get(SongKeys.SONG_RATING).getAsFloat();

            JsonArray imagesArray = songData.get(SongKeys.SONG_IMAGES_ARRAY).getAsJsonArray();
            HashMap<Integer, String> songImages = extractImagesFromJsonArray(imagesArray);

            currentSong.setSongTitle(title);
            currentSong.setSongArtist(artist);
            currentSong.setSongViews(views);
            currentSong.setSongRating(rating);
            currentSong.setSongImageSmall(songImages.get(0));
            songs.add(currentSong);
        }
        return songs;
    }

    public HashMap<Integer, String> extractImagesFromJsonArray(JsonArray array){
        HashMap<Integer, String> images = new HashMap<>();
        int size = array.size();
        for (int i = 0; i < size; i++) {
            JsonObject imagesObject = array.get(i).getAsJsonObject();
            String     imageSmall   = imagesObject.get(SongKeys.SONG_IMAGE_SMALL).getAsString();
            String     imageMedium  = imagesObject.get(SongKeys.SONG_IMAGE_MEDIUM).getAsString();

            images.put(0, imageSmall);
            images.put(1, imageMedium);
        }
        return images;
    }
}































