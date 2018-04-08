package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.Mapper.FilmMapper;
import com.netcracker.infrastructure.Mapper.FullFilmMapper;
import com.netcracker.infrastructure.Mapper.StyleMapper;
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
public class StyleRepositoryImpl {


    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
    public StyleRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Style style) {
        String sql = "INSERT INTO STYLES (STYLE_ID,STYLE_NAME ) VALUES" +
                " (:style_id, :style_name)";

        Map namedParameters = new HashMap();
        namedParameters.put("style_id", style.getStyleId());
        namedParameters.put("style_name", style.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public List<Style> loadAll() {
        String sql = "SELECT * FROM STYLES";
        Map namedParameters = new HashMap();

        List<Style> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StyleMapper()
        );

        return result;
    }

    public List<Style> loadByStyleName(String styleName) {

        String sql = "SELECT * FROM STYLES WHERE STYLE_NAME=:stylename";
        Map namedParameters = new HashMap();
        namedParameters.put("stylename", styleName);

        List<Style> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StyleMapper());
        return result;
    }

    public Style loadByStyleID(String styleId) {

        String sql = "SELECT * FROM STYLES WHERE STYLE_ID=:styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("styleid", styleId);

        Style result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new StyleMapper());
        return result;
    }

    public List<Style> loadAllFull() {
        String sql = "SELECT * FROM STYLES";
        Map namedParameters = new HashMap();

        List<Style> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StyleMapper()
        );

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMS WHERE STYLE_ID=:styleid";
            namedParameters.clear();
            namedParameters.put("styleid", result.get(i).getStyleId());

            List<Film> films = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new FilmMapper());

            result.get(i).setFilms(films);
            for (int j=0;j<result.get(i).getFilms().size();j++){
                result.get(i).getFilms().get(j).setStyle(loadByStyleID(result.get(i).getStyleId()));

            }
        }

        return result;
    }

    public List<Style> loadByStyleNameFull(String styleName) {

        String sql = "SELECT * FROM STYLES WHERE STYLE_NAME=:stylename";
        Map namedParameters = new HashMap();
        namedParameters.put("stylename", styleName);

        List<Style> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new StyleMapper());

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMS WHERE STYLE_ID=:styleid";
            namedParameters.clear();
            namedParameters.put("styleid", result.get(i).getStyleId());

            List<Film> films = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new FullFilmMapper());

            result.get(i).setFilms(films);
        }

        return result;
    }

    public Style loadByStyleIDFull(String styleId) {

        String sql = "SELECT * FROM STYLES WHERE STYLE_ID=:styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("styleid", styleId);

        Style result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new StyleMapper());

        sql = "SELECT * FROM FILMS WHERE STYLE_ID=:styleid";
        namedParameters.clear();
        namedParameters.put("styleid", styleId);

        List<Film> films = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper());

        result.setFilms(films);

        return result;
    }

    public void deleteAll(){

        String sql = "DELETE FROM STYLES";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteStyleName(String styleName) {

        String sql = "DELETE FROM STYLES WHERE STYLE_NAME=:stylename";
        Map namedParameters = new HashMap();
        namedParameters.put("stylename", styleName);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteStyleId(String styleId) {

        String sql = "DELETE FROM STYLES WHERE STYLE_ID=:styleid";
        Map namedParameters = new HashMap();
        namedParameters.put("styleid", styleId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }



}
