package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ActorMapper implements RowMapper<Actor> {

    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {

        String actorId = rs.getString("ACTOR_ID");
        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");
        String birthdate = rs.getString("BIRTHDATE");

        Actor result = new Actor(actorId, firstName,lastName,birthdate );

        return result;
    }
}