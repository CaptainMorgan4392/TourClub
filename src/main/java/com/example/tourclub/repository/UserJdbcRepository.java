package com.example.tourclub.repository;

import com.example.tourclub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsersWithMoreThanOneTrips() {
        return jdbcTemplate.query(
          "select u.* from system_user u " +
              "inner join trip_users tu on u.id = tu.user_id " +
              "group by u.id " +
              "having count(*) > 1",
          new UserRowMapper()
        );
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("patronymic"),
                rs.getDate("birthday"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("gender"),
                rs.getString("role")
            );
        }
    }

}
