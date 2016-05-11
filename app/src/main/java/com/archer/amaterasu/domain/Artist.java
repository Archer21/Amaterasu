package com.archer.amaterasu.domain;

//"artists":{
//    "artist":[{
//        "id":1,
//        "name":"Eyelis",
//        "debut":"21-06-2015",
//        "gender":"K-Pop",
//        "images":[{
//            "cover":"http://blog-imgs-53.fc2.com/g/e/i/geitsuboo/20130515165800.jpg",
//            "photo":"http://download.minitokyo.net/Elisa.434244.jpg"
//        }],
//        "albums":["Kizuna ni nosete"],
//        "votes":1568,
//        "rating":5.0
//    }]
//}

public class Artist {
    private int      id;
    private String[] albums;
    private String   debut;
    private String   gender;
    private int      votes;
    private float    rating;
    private String   name;
    private String   cover;
    private String   photo;

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
