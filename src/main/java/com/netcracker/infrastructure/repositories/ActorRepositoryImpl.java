package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.Actor;
import com.netcracker.entity.Film;
import com.netcracker.entity.FilmActor;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.Mapper.ActorMapper;
import com.netcracker.infrastructure.Mapper.FilmActorMapper;
import com.netcracker.infrastructure.Mapper.FilmMapper;
import com.netcracker.infrastructure.Mapper.FullFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ActorRepositoryImpl {
    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ActorRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Actor actor) {
        String sql = "INSERT INTO ACTORS (ACTOR_ID,FIRST_NAME,LAST_NAME,BIRTHDATE ) VALUES" +
                " (:actor_id, :first_name, :last_name, :birthdate)";

        Map namedParameters = new HashMap();
        namedParameters.put("actor_id", actor.getActorid());
        namedParameters.put("first_name", actor.getFirstname());
        namedParameters.put("last_name", actor.getLastname());
        namedParameters.put("birthdate", actor.getBirthdate());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void insertFull(Actor actor) {
        String sql = "INSERT INTO ACTORS (ACTOR_ID,FIRST_NAME,LAST_NAME,BIRTHDATE ) VALUES" +
                " (:actor_id, :first_name, :last_name, :birthdate)";

        Map namedParameters = new HashMap();
        namedParameters.put("actor_id", actor.getActorid());
        namedParameters.put("first_name", actor.getFirstname());
        namedParameters.put("last_name", actor.getLastname());
        namedParameters.put("birthdate", actor.getBirthdate());
        namedParameterJdbcTemplate.update(sql, namedParameters);

        if (actor.getFilms()!=null){
            sql = "INSERT INTO FILMACTOR (FILM_ID, ACTOR_ID ) VALUES" +
                    " (:film_id, :actor_id)";
            namedParameters.clear();
            for (int i=0;i<actor.getFilms().size();i++){
                namedParameters.put("film_id", actor.getFilms().get(i).getFilmId());
                namedParameters.put("actor_id", actor.getActorid());
                namedParameterJdbcTemplate.update(sql, namedParameters);
                namedParameters.clear();
            }
        }
    }

    public List<Actor> loadAll() {
        String sql = "SELECT * FROM ACTORS";
        Map namedParameters = new HashMap();

        List<Actor> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new ActorMapper()
        );

        return result;
    }

    public List<Actor> loadByFirstName(String firstName) {

        String sql = "SELECT * FROM ACTORS WHERE FIRST_NAME=:firstname";
        Map namedParameters = new HashMap();
        namedParameters.put("firstname", firstName);

        List<Actor> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new ActorMapper());
        return result;
    }

    public List<Actor> loadByLastName(String lastName) {

        String sql = "SELECT * FROM ACTORS WHERE LAST_NAME=:lastname";
        Map namedParameters = new HashMap();
        namedParameters.put("lastname", lastName);

        List<Actor> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new ActorMapper());
        return result;
    }

    public Actor loadByActorID(String actorId) {

        String sql = "SELECT * FROM ACTORS WHERE ACTOR_ID=:actorid";
        Map namedParameters = new HashMap();
        namedParameters.put("actorid", actorId);

        Actor result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new ActorMapper());
        return result;
    }

    public List<Actor> loadByBirthdate(String birthdate) {

        String sql = "SELECT * FROM ACTORS WHERE BIRTHDATE=:birthdate";
        Map namedParameters = new HashMap();
        namedParameters.put("birthdate", birthdate);

        List<Actor> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new ActorMapper());
        return result;
    }

    public List<Actor> loadAllFull() {
        String sql = "SELECT * FROM ACTORS";
        Map namedParameters = new HashMap();

        List<Actor> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new ActorMapper()
        );



        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMACTOR fa join FILMS f ON fa.FILM_ID=f.FILM_ID WHERE ACTOR_ID=:actorid";
            namedParameters.clear();
            namedParameters.put("actorid", result.get(i).getActorid());

            List<Film> films = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new FilmMapper());

            result.get(i).setFilms(films);
        }








//        for (int i=0;i<result.size();i++){
//            sql = "SELECT * FROM FILMACTOR WHERE ACTOR_ID=:actorid";
//            namedParameters.clear();
//            namedParameters.put("actorid", result.get(i).getActorid());
//
//            List<FilmActor> filmsactor = namedParameterJdbcTemplate.query(
//                    sql,
//                    namedParameters,
//                    new FilmActorMapper());
//
//            List<Film> films=new ArrayList<Film>();
//
//            for(int j=0;j<filmsactor.size();j++){
//                sql = "SELECT * FROM FILMS WHERE FILM_ID=:filmid";
//                namedParameters.clear();
//                namedParameters.put("filmid", filmsactor.get(i).getFilmId());
//
//                Film film = namedParameterJdbcTemplate.queryForObject(
//                        sql,
//                        namedParameters,
//                        new FullFilmMapper());
//                films.add(film);
//            }
//
//            result.get(i).setFilms(films);
//        }

        return result;
    }

    public void deleteAll(){

        String sql = "DELETE FROM ACTORS";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteFirstName(String firstName) {

        String sql = "DELETE FROM ACTORS WHERE FIRST_NAME=:firstname";
        Map namedParameters = new HashMap();
        namedParameters.put("firstname", firstName);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteLastName(String lastName) {

        String sql = "DELETE FROM ACTORS WHERE LAST_NAME=:lastname";
        Map namedParameters = new HashMap();
        namedParameters.put("lastname", lastName);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteActorId(String actorId) {

        String sql = "DELETE FROM ACTORS WHERE ACTOR_ID=:actorid";
        Map namedParameters = new HashMap();
        namedParameters.put("actorid", actorId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteBirthdate(String Birthdate) {

        String sql = "DELETE FROM ACTORS WHERE BIRTHDATE=:birthdate";
        Map namedParameters = new HashMap();
        namedParameters.put("birthdate", Birthdate);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

}
