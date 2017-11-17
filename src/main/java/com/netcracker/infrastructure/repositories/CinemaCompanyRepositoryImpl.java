package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaCompanyRepositoryImpl implements CinemaCompanyRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CinemaCompanyRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(CinemaCompany company) {
        String sql = "INSERT INTO CINEMACOMPANY (COMPANY_ID,COMPANY_NAME ) VALUES" +
                " (:company_id, :company_name)";

        Map namedParameters = new HashMap();
        namedParameters.put("company_id", company.getCompanyid());
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

    public List<CinemaCompany> loadByCompanyID(String companyId) {

        String sql = "SELECT * FROM CINEMACOMPANY WHERE COMPANY_ID=:companyid";
        Map namedParameters = new HashMap();
        namedParameters.put("companyid", companyId);

        List<CinemaCompany> result = namedParameterJdbcTemplate.query(
                sql,
                namedParameters,
                new CinemaCompanyMapper());
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


    public static final class CinemaCompanyMapper implements RowMapper<CinemaCompany> {

        public CinemaCompany mapRow(ResultSet rs, int rowNum) throws SQLException {

            String companyid = rs.getString("COMPANY_ID");
            String companyname = rs.getString("COMPANY_NAME");

            CinemaCompany cinemaCompany = new CinemaCompany(companyid, companyname);
            //cinemaCompany.setBookId(bookId);

            return cinemaCompany;
        }
    }
}
