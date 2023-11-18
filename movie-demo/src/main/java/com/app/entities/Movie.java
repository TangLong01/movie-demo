package com.app.entities;

public class Movie {
    Integer id, yearOfRelease;
    String title, genre;

    public Movie(Integer id, String title, String genre, Integer yearOfRelease) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public Movie(String title, String genre, Integer yearOfRelease) {
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }
}
