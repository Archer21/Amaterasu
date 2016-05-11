package com.archer.amaterasu.io;


//"songs": {
//    "song": [{
//        "id": 1,
//        "title": "Kizuna ni Nosete",
//        "artist": "eyelis",
//        "images": [{
//            "small": "http://www.openingsanimes.com/wp-content/uploads/2015/07/Akagami-no-Shirayuki-hime1.jpg?a5f169",
//            "medium": "https://i1.sndcdn.com/artworks-000131684169-egp2ia-t500x500.jpg"
//        }],
//        "views": 1568,
//        "rating": 4.8,
//        "year": "2015"
//    }]
//}

public class ApiConstants {
    /**
     * Api URL Json Keys https://api.myjson.com/bins/2qtzx
     */

    public static final String BASE_URL  = "https://api.myjson.com/";
    public static final String PATH_BINS = "bins/";

    /**
     * Api URL Songs Json Keys 2qtzx
     */

    public static final String PARAM_SONGS = "2qtzx";
    public static final String SONGS_URL   = PATH_BINS + PARAM_SONGS;


    /**
     * Api URL Json Artist Keys https://api.myjson.com/bins/tl69
     */

    public static final String PARAM_ARTIST = "tl69";
    public static final String ARTIST_URL   = PATH_BINS + PARAM_ARTIST;
}

































