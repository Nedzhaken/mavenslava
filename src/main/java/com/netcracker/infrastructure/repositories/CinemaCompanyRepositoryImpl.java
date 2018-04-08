package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.infrastructure.Mapper.CinemaCompanyMapper;
import com.netcracker.infrastructure.Mapper.FilmMapper;
import com.netcracker.infrastructure.Mapper.FullFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CinemaCompanyRepositoryImpl {
    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CinemaCompanyRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(CinemaCompany company) {
        String sql = "INSERT INTO CINEMACOMPANY (COMPANY_ID,COMPANY_NAME ) VALUES" +
                " (:company_id, :company_name)";

        Map namedParameters = new HashMap();
        namedParameters.put("company_id", company.getCompanyId());
        namedParameters.put("company_name", company.getCompanyname());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public List<CinemaCompany> loadAll() {
        String sql = "SELECT * FROM CINEMACOMPANY";
        Map namedParameters = new HashMap();

        List<CinemaCompany> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new CinemaCompanyMapper()
        );

        return result;
    }

    public List<CinemaCompany> loadByCompanyName(String companyName) {

        String sql = "SELECT * FROM CINEMACOMPANY WHERE COMPANY_NAME=:companyname";
        Map namedParameters = new HashMap();
        namedParameters.put("companyname", companyName);

        List<CinemaCompany> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new CinemaCompanyMapper());
        return result;
    }

    public CinemaCompany loadByCompanyID(String companyId) {

        String sql = "SELECT * FROM CINEMACOMPANY WHERE COMPANY_ID=:companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("companyid", companyId);

        CinemaCompany result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new CinemaCompanyMapper());

        return result;
    }


    public List<CinemaCompany> loadAllFull() {
        String sql = "SELECT * FROM CINEMACOMPANY";
        Map namedParameters = new HashMap();

        List<CinemaCompany> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new CinemaCompanyMapper()
        );

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMS WHERE COMPANY_ID=:companyid";
            namedParameters.clear();
            namedParameters.put("companyid", result.get(i).getCompanyId());

            List<Film> films = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new FilmMapper());

            result.get(i).setFilms(films);
        }

        return result;
    }

    public List<CinemaCompany> loadByCompanyNameFull(String companyName) {

        String sql = "SELECT * FROM CINEMACOMPANY WHERE COMPANY_NAME=:companyname";
        Map namedParameters = new HashMap();
        namedParameters.put("companyname", companyName);

        List<CinemaCompany> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new CinemaCompanyMapper());

        for (int i=0;i<result.size();i++){
            sql = "SELECT * FROM FILMS WHERE COMPANY_ID=:companyid";
            namedParameters.clear();
            namedParameters.put("companyid", result.get(i).getCompanyId());

            List<Film> films = namedParameterJdbcTemplate.query(
                    sql,
                    namedParameters,
                    new FullFilmMapper());

            result.get(i).setFilms(films);
        }
        return result;
    }

    public CinemaCompany loadByCompanyIDFull(String companyId) {

        String sql = "SELECT * FROM CINEMACOMPANY WHERE COMPANY_ID=:companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("companyid", companyId);

        CinemaCompany result = namedParameterJdbcTemplate.queryForObject(
                sql,
                namedParameters,
                new CinemaCompanyMapper());

        sql = "SELECT * FROM FILMS WHERE COMPANY_ID=:companyid";
        namedParameters.clear();
        namedParameters.put("companyid", companyId);

        List<Film> films = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new FullFilmMapper());

        result.setFilms(films);
        return result;
    }


    public void deleteAll(){

        String sql = "DELETE FROM CINEMACOMPANY";

        Map namedParameters = new HashMap();

        namedParameterJdbcTemplate.update(sql,namedParameters);
    }

    public void deleteCompanyName(String companyName) {

        String sql = "DELETE FROM CINEMACOMPANY WHERE COMPANY_NAME=:companyname";
        Map namedParameters = new HashMap();
        namedParameters.put("companyname", companyName);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

    public void deleteCompanyId(String companyId) {

        String sql = "DELETE FROM CINEMACOMPANY WHERE COMPANY_ID=:companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("companyid", companyId);
        namedParameterJdbcTemplate.update(sql,namedParameters);

    }

}
