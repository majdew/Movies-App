package edu.ppu.movies;

import java.util.ArrayList;

/**
 * Created by Mohammed on 22/11/2016.
 */

public class Movie {

    private String title;
    private String image;
    private String rating;
    private String releasedate;
    private ArrayList<String> genre;

    // constructors and getters and setters
    // ......


    public Movie(String title, String image, String rating, String releasedate, ArrayList<String> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releasedate = releasedate;
        this.genre = genre;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
