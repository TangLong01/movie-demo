package com.app;

import com.app.model.MovieDAO;
import com.app.model.MovieDAOImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Movie extends HttpServlet {
    private MovieDAO movieDAO;
    static final String DB_URL = "jdbc:mysql://localhost:3306/movie?allowPublicKeyRetrieval=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "long200801";

    public void init() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            movieDAO = new MovieDAOImp(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            init();

            List<com.app.entities.Movie> movies = movieDAO.findAll();
            req.setAttribute("movies", movies);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/list-movie.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                String movieTitle = req.getParameter("title");
                String movieGenre = req.getParameter("genre");
                Integer movieYear = Integer.valueOf(req.getParameter("year"));

                if (!"".equals(movieTitle) && !"".equals(movieGenre)) {
                    try {
                        movieDAO.addMovie(new com.app.entities.Movie(movieTitle, movieGenre, movieYear));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case "delete":
                Integer movieIdDelete = Integer.valueOf(req.getParameter("movieIdDelete"));
                try {
                    movieDAO.deleteMovie(movieIdDelete);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                String newTitle = req.getParameter("newTitle");
                Integer movieIdUpdate = Integer.valueOf(req.getParameter("movieIdUpdate"));
                if (!"".equals(newTitle)) {
                    try {
                        movieDAO.updateMovieTitle(movieIdUpdate, newTitle);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
        }

        try {
            init();
            List<com.app.entities.Movie> movies = movieDAO.findAll();
            req.setAttribute("movies", movies);
            resp.sendRedirect(req.getContextPath() + "/movie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
