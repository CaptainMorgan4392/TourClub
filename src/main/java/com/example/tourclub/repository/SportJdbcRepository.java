package com.example.tourclub.repository;

import com.example.tourclub.projection.SportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SportJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SportProjection> getSportsWithoutSection() {
        return jdbcTemplate.query(
            "select s.* from sport s " +
                "left join section s2 on s.id = s2.sport_id " +
                "where s2.id is null",
            new SportRowMapper()
        );
    }

    private class SportRowMapper implements RowMapper<SportProjection> {

        @Override
        public SportProjection mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new SportProjection(
                rs.getInt("id"),
                rs.getString("name")
            );
        }

    }

}
