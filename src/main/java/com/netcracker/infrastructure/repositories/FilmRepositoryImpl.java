package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.*;
import com.netcracker.infrastructure.Mapper.ActorMapper;
import com.netcracker.infrastructure.Mapper.FilmActorMapper;
import com.netcracker.infrastructure.Mapper.FilmMapper;
import com.netcracker.infrastructure.Mapper.FullFilmMapper;
import com.netcracker.infrastructure.services.ProxyFilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FilmRepositoryImpl{
    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FilmRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Film film) {
        String sql = "INSERT INTO FILMS (FILM_ID,FILM_NAME,RELESE_DATE, STYLE_ID, COMPANY_ID ) VALUES" +
                " (:film_id, :film_name, :release_date, :film_styleid, :film_companyid)";

        Map namedParameters = new HashMap();
        namedParameters.put("film_id", film.getFilmId());
        namedParameters.put("film_name", film.getName());
        namedParameters.put("release_date", film.getReleasedate());
        namedParameters.put("film_styleid", film.getStyle().getStyleId());
        namedParameters.put("film_companyid", film.getCompany().getCompanyId());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }
    public void insertFull(Film film) {
        String sql = "INSERT INTO FILMS (FILM_ID,FILM_NAME,RELESE_DATE, STYLE_ID, COMPANY_ID ) VALUES" +
                " (:film_id, :film_name, :release_date, :film_styleid, :film_companyid)";

        Map namedParameters = new HashMap();
        namedParameters.put("film_id", film.getFilmId());
        namedParameters.put("film_name", film.getName());
        namedParameters.put("release_date", film.getReleasedate());
        namedParameters.put("film_styleid", film.getStyle().getStyleId());
        namedParameters.put("film_companyid", film.getCompany().getCompanyId());
        namedParameterJdbcTemplate.update(sql, namedParameters);

        if (film.getActors()!=null){
            sql = "INSERT INTO FILMACTOR (FILM_ID, ACTOR_ID ) VALUES" +
                    " (:film_id, :actor_id)";
            namedParameters.clear();
            for (int i=0;i<film.getActors().size();i++){
                namedParameters.put("film_id", film.getFilmId());
                namedParameters.put("actor_id", film.getActors().get(i).getActorid());
                namedParameterJdbcTemplate.update(sql, namedParameters);
                namedParameters.clear();
            }
        }
    }


    public List<Film> loadAll() {
        String sql = "SELECT * FROM FILMS";
        Map namedParameters = new HashMap();

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper()
        );

        return result;
    }

    public Film loadByFilmId(String filmId) {

        String sql = "SELECT * FROM FILMS WHERE FILM_ID=:filmid";
        Map namedParameters = new HashMap();
        namedParameters.put("filmid", filmId);

        Film result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }

    public List<Film> loadByFilmName(String filmName) {

        String sql = "SELECT * FROM FILMS WHERE FILM_NAME=:filmname";
        Map namedParameters = new HashMap();
        namedParameters.put("filmname", filmName);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }

    public List<Film> loadByReleaseDate(String releaseDate) {

        String sql = "SELECT * FROM FILMS WHERE RELESE_DATE=:releasedate";
        Map namedParameters = new HashMap();
        namedParameters.put("releasedate", releaseDate);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }

    public List<Film> loadByFilmStyleId(String styleId) {

        String sql = "SELECT * FROM FILMS WHERE STYLE_ID=:film_styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_styleid", styleId);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }

    public List<Film> loadByFilmCompanyId(String companyId) {

        String sql = "SELECT * FROM FILMS WHERE COMPANY_ID=:film_companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_companyid", companyId);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }



    public List<Film> loadFullAll() {
        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID";
        Map namedParameters = new HashMap();

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper()
        );

        return result;
    }

    public Film loadByFullFilmId(String filmId) {

        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.FILM_ID=:filmid";
        Map namedParameters = new HashMap();
        namedParameters.put("filmid", filmId);

        Film result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new FullFilmMapper());
        return result;
    }

    public List<Film> loadByFullFilmName(String filmName) {

        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.FILM_NAME=:filmname";
        Map namedParameters = new HashMap();
        namedParameters.put("filmname", filmName);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper());
        return result;
    }

    public List<Film> loadByFullReleaseDate(String releaseDate) {

        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.RELESE_DATE=:releasedate";
        Map namedParameters = new HashMap();
        namedParameters.put("releasedate", releaseDate);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper());
        return result;
    }

    public List<Film> loadByFullFilmStyleId(String styleId) {

        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.STYLE_ID=:film_styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_styleid", styleId);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper());
        return result;
    }

    public List<Film> loadByFullFilmCompanyId(String companyId) {

        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.COMPANY_ID=:film_companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_companyid", companyId);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FilmMapper());
        return result;
    }


    public List<Film> loadFilmWithActor() {
        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID " +
                "JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID ";
        Map namedParameters = new HashMap();

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper()
        );

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMACTOR f join ACTORS a ON f.ACTOR_ID=a.ACTOR_ID WHERE FILM_ID=:filmid";
            namedParameters.clear();
            namedParameters.put("filmid", result.get(i).getFilmId());
            List<Actor> actors = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new ActorMapper());

            result.get(i).setActors(actors);

        }

        return result;
    }

    public List<Film> loadByFilmNameWithActor(String filmName) {
        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID " +
                "JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.FILM_NAME=:filmname ";
        Map namedParameters = new HashMap();
        namedParameters.put("filmname", filmName);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper()
        );

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMACTOR f join ACTORS a ON f.ACTOR_ID=a.ACTOR_ID WHERE FILM_ID=:filmid";
            namedParameters.clear();
            namedParameters.put("filmid", result.get(i).getFilmId());
            List<Actor> actors = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new ActorMapper());

            result.get(i).setActors(actors);

        }

        return result;
    }

    public List<Film> loadByFilmPartNameWithActor(String filmName) {
        filmName="%"+filmName+"%";
        String sql = "SELECT * FROM FILMS f join STYLES s ON f.STYLE_ID=s.STYLE_ID " +
                "JOIN CINEMACOMPANY c ON f.COMPANY_ID=c.COMPANY_ID WHERE f.FILM_NAME LIKE :filmname ";
        Map namedParameters = new HashMap();
        namedParameters.put("filmname", filmName);

        List<Film> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper()
        );

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMACTOR f join ACTORS a ON f.ACTOR_ID=a.ACTOR_ID WHERE FILM_ID=:filmid";
            namedParameters.clear();
            namedParameters.put("filmid", result.get(i).getFilmId());
            List<Actor> actors = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new ActorMapper());

            result.get(i).setActors(actors);

        }

        return result;
    }


    public void deleteAll(){

        String sql = "DELETE FROM FILMS";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteFilmId(String filmId) {

        String sql = "DELETE FROM FILMS WHERE FILM_ID=:filmid";
        Map namedParameters = new HashMap();
        namedParameters.put("filmid", filmId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteFilmName(String filmName) {

        String sql = "DELETE FROM FILMS WHERE FILM_NAME=:filmname";
        Map namedParameters = new HashMap();
        namedParameters.put("filmname", filmName);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteReleaseDate(String releaseDate) {

        String sql = "DELETE FROM FILMS WHERE RELEASE_DATE=:releasedate";
        Map namedParameters = new HashMap();
        namedParameters.put("releasedate", releaseDate);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteFilmStyleId(String styleId) {

        String sql = "DELETE FROM FILMS WHERE STYLE_ID=:film_styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_styleid", styleId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteFilmCompanyId(String companyId) {

        String sql = "DELETE FROM FILMS WHERE COMPANY_ID=:film_companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("film_companyid", companyId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }
}
