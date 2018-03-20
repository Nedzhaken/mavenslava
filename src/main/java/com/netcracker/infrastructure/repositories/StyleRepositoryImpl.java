package com.netcracker.infrastructure.repositories;

import com.netcracker.entity.CinemaCompany;
import com.netcracker.entity.Film;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.Mapper.FilmMapper;
import com.netcracker.infrastructure.Mapper.FullFilmMapper;
import com.netcracker.infrastructure.Mapper.StyleMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StyleRepositoryImpl implements StyleRepository {
//    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public StyleRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }

    private final DataSource dataSource;

    public StyleRepositoryImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public void insert(Style style) {
//        String sql = "INSERT INTO STYLES (STYLE_ID,STYLE_NAME ) VALUES" +
//                " (:style_id, :style_name)";
//
//        Map namedParameters = new HashMap();
//        namedParameters.put("style_id", style.getStyleId());
//        namedParameters.put("style_name", style.getName());
//        namedParameterJdbcTemplate.update(sql, namedParameters);
        String sql="INSERT INTO STYLES(STYLE_ID, STYLE_NAME) VALUE (?, ?)";
        try(Connection connection=dataSource.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,style.getStyleId());
            preparedStatement.setString(2,style.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
            throw new IllegalStateException();
        }
    }

    public List<Style> loadAll() {
//        String sql = "SELECT * FROM STYLES";
//        Map namedParameters = new HashMap();
//
//        List<Style> result = namedParameterJdbcTemplate.query(
//                sql,
//                namedParameters,
//                new StyleMapper()
//        );
//
//        return result;
        String sql="SELECT * FROM STYLES";
        try (Connection connection=dataSource.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();

            List<Style> styleList=new ArrayList<>();
            while (rs.next()){
                String style_id=rs.getString("STYLE_ID");
                String name=rs.getString("STYLE_NAME");
                Style style=new Style(style_id,name);
                styleList.add(style);
            }
            return styleList;
        }
        catch (SQLException e){
            System.out.println(e);
            throw new IllegalStateException();
        }
    }

    public List<Style> loadByStyleName(String styleName) {

//        String sql = "SELECT * FROM STYLES WHERE STYLE_NAME=:stylename";
//        Map namedParameters = new HashMap();
//        namedParameters.put("stylename", styleName);
//
//        List<Style> result = namedParameterJdbcTemplate.query(
//                sql,
//                namedParameters,
//                new StyleMapper());
//        return result;
        String sql="SELECT * FROM STYLES WHERE STYLE_ID = ?";
        try( Connection connection=dataSource.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,styleName);
            ResultSet rs=preparedStatement.executeQuery();
            List<Style> styleList=new ArrayList<>();
            while(rs.next()) {
                String style_id = rs.getString("STYLE_ID");
                String name = rs.getString("STYLE_NAME");
                Style style=new Style(style_id,name);
                styleList.add(style);
            }
            return styleList;

        } catch (SQLException e) {
            System.out.println(e);
            throw new IllegalStateException();
        }
    }

    public Style loadByStyleID(String styleId) {

//        String sql = "SELECT * FROM STYLES WHERE STYLE_ID=:styleid";
//        Map namedParameters = new HashMap();
//        namedParameters.put("styleid", styleId);
//
//        Style result = namedParameterJdbcTemplate.queryForObject(
//                sql,
//                namedParameters,
//                new StyleMapper());
//        return result;
        String sql="SELECT * FROM STYLES WHERE STYLE_ID = ?";
        try( Connection connection=dataSource.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,styleId);
            ResultSet rs=preparedStatement.executeQuery();
            rs.next();
            String style_id=rs.getString("STYLE_ID");
            String name=rs.getString("STYLE_NAME");
            return new Style(style_id,name);

        } catch (SQLException e) {
            System.out.println(e);
            throw new IllegalStateException();
        }
    }

    public void deleteAll(){

//        String sql = "DELETE FROM STYLES";
//        Map namedParameters = new HashMap();
//        namedParameterJdbcTemplate.update(sql,namedParameters);

        String sql = "DELETE FROM STYLES";
        try (Connection connection=dataSource.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
            throw new IllegalStateException();
        }
    }

    public void deleteStyleName(String styleName) {

//        String sql = "DELETE FROM STYLES WHERE STYLE_NAME=:stylename";
//        Map namedParameters = new HashMap();
//        namedParameters.put("stylename", styleName);
//        namedParameterJdbcTemplate.update(sql,namedParameters);

        String sql = "DELETE FROM STYLES WHERE STYLE_NAME=?";

        try (Connection connection=dataSource.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,styleName);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
            throw new IllegalStateException();
        }

    }

    public void deleteStyleId(String styleId) {

//        String sql = "DELETE FROM STYLES WHERE STYLE_ID=:styleid";
//        Map namedParameters = new HashMap();
//        namedParameters.put("styleid", styleId);
//        namedParameterJdbcTemplate.update(sql,namedParameters);

        String sql = "DELETE FROM STYLES WHERE STYLE_ID=?";

        try (Connection connection=dataSource.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,styleId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
            throw new IllegalStateException();
        }

    }



}
