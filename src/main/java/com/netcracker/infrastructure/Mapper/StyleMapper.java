package com.netcracker.infrastructure.Mapper;

import com.netcracker.entity.Style;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class StyleMapper implements RowMapper<Style> {

    public Style mapRow(ResultSet rs, int rowNum) throws SQLException {

        String styleid = rs.getString("STYLE_ID");
        String stylename = rs.getString("STYLE_NAME");

        Style result = new Style(styleid, stylename);

        return result;
    }
}
