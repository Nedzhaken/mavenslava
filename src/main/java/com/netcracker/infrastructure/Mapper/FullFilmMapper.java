package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class FullFilmMapper implements RowMapper<Film> {

    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {

        String filmId = rs.getString("FILM_ID");
        String filmName = rs.getString("FILM_NAME");
        String releaseDate = rs.getString("RELESE_DATE");

        String styleId = rs.getString("STYLE_ID");
        String styleName=rs.getString("STYLE_NAME");

        String companyId=rs.getString("COMPANY_ID");
        String companyName=rs.getString("COMPANY_NAME");

        Style style =new Style(styleId,styleName);
        CinemaCompany cinemaCompany=new CinemaCompany(companyId,companyName);

        Film film = new Film(filmId, filmName, releaseDate);
        film.setCompany(cinemaCompany);
        film.setStyle(style);

        return film;
    }
}