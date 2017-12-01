package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class FilmMapper implements RowMapper<Film> {

    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {

        String filmId = rs.getString("FILM_ID");
        String filmName = rs.getString("FILM_NAME");
        String releaseDate = rs.getString("RELESE_DATE");

        Film film = new Film(filmId, filmName, releaseDate);

        return film;
    }
}
