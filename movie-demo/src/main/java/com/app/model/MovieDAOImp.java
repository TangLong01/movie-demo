package com.app.model;

import com.app.entities.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImp implements MovieDAO {
    private final Connection conn;

    public MovieDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        String sql = "SELECT * FROM movie";
        List<Movie> listMovies = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listMovies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("genre"), rs.getInt("yearOfRelease")));
        }
        return listMovies;
    }

    @Override
    public void addMovie(Movie movie) throws SQLException {
        String sql = "INSERT INTO movie (title, genre, yearOfRelease) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getYearOfRelease());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateMovieTitle(Integer id, String newTitle) throws SQLException {
        String sql = "UPDATE movie SET title=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newTitle);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(Integer id) throws SQLException {
        String sql = "DELETE FROM movie WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Movie> findMovieById(int id) throws SQLException {
        return null;
    }
}
