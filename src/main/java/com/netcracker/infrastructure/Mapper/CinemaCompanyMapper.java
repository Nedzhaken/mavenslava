package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.CinemaCompany;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CinemaCompanyMapper implements RowMapper<CinemaCompany> {

    public CinemaCompany mapRow(ResultSet rs, int rowNum) throws SQLException {

        String companyid = rs.getString("COMPANY_ID");
        String companyname = rs.getString("COMPANY_NAME");

        CinemaCompany cinemaCompany = new CinemaCompany(companyid, companyname);

        return cinemaCompany;
    }
}
