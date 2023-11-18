package com.app.model;

import com.app.entities.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {
    List<Movie> findAll() throws SQLException;

    void addMovie(Movie movie) throws SQLException;

    void updateMovieTitle(Integer id, String newTitle) throws SQLException;

    void deleteMovie(Integer id) throws SQLException;

    List<Movie> findMovieById(int id) throws SQLException;
}
