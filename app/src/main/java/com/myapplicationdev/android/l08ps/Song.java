package com.myapplicationdev.android.l08ps;

public class Song {
    private int id;
    private String title;
    private String singers;
    private int year;
    private String stars;

    public Song(int id, String title, String singers, int year, String stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getSingers() {return singers;}
    public int getYear() {return year;}
    public String getStars() {return stars;}
    public String toString() {return id + "\n" + "Song Title: " + title + "\n" + "Singer Name: " + singers
            + "\n" + "Year of Song Release: " + year + "\n" + "Rating: " + stars;}
}
