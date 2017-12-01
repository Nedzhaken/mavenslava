package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.Film;
import com.netcracker.entity.FilmActor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class FilmActorMapper implements RowMapper<FilmActor> {

    public FilmActor mapRow(ResultSet rs, int rowNum) throws SQLException {

        String filmId = rs.getString("FILM_ID");
        String actorId = rs.getString("ACTOR_ID");

        FilmActor filmActor = new FilmActor(filmId,actorId);

        return filmActor;
    }
}
