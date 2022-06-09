package com.example.tourclub.service;

import com.example.tourclub.dto.CompetitionDTO;
import com.example.tourclub.dto.TripResponseDTO;
import com.example.tourclub.dto.UserResponseDTO;
import com.example.tourclub.entity.Competition;
import com.example.tourclub.entity.Group;
import com.example.tourclub.entity.Trip;
import com.example.tourclub.entity.User;
import com.example.tourclub.repository.*;
import com.example.tourclub.token.Base64AuthenticationToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserJdbcRepository userJdbcRepository;

    public boolean isValidToken(Base64AuthenticationToken token){
        return userInfoRepository.findByEmail(token.getEmail()).isPresent();
    }

    public String getMailByToken(Base64AuthenticationToken token){
         return userInfoRepository.findByEmail(token.getEmail()).get().getEmail();
    }

    public List<TripResponseDTO> getTrips(String mail) {
        Integer id = userRepository.findByEmail(mail).get().getId();
        String sqlSelectIds = "select trip_id from trip_users where user_id = ?";
        List<Integer> tripsIds = jdbcTemplate.queryForList(sqlSelectIds, Integer.class, id);
        List<Trip> trips = tripRepository.findAllByIdIn(tripsIds);
        if(trips.size() == 0)
            return new ArrayList<>();
        return trips.stream().map(TripResponseDTO::new).collect(Collectors.toList());
    }

    public List<Competition> getCompetitions(String mail) {
        Integer id = userRepository.findByEmail(mail).get().getId();
        String sqlSelectIds = "select trip_id from trip_users where user_id = ?";
        List<Integer> tripsIds = jdbcTemplate.queryForList(sqlSelectIds, Integer.class, id);
        List<Competition> competitions = competitionRepository.findAllByIdIn(tripsIds);
        if(competitions.size() == 0)
            return new ArrayList<>();
        return competitions;
    }

    public List<Group> getGroups(String mail) {
        Integer id = userRepository.findByEmail(mail).get().getId();
        String sqlSelectIds = "select trip_id from trip_users where user_id = ?";
        List<Integer> tripsIds = jdbcTemplate.queryForList(sqlSelectIds, Integer.class, id);
        List<Group> groups = groupRepository.findAllByIdIn(tripsIds);
        if(groups.size() == 0)
            return new ArrayList<>();
        return groups;
    }

    public List<UserResponseDTO> getUsersWithMoreThanOneTrips() {
        return userJdbcRepository.getUsersWithMoreThanOneTrips()
            .stream()
            .map(user -> new UserResponseDTO(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getPatronymic(),
                new SimpleDateFormat("yyyy-MM-dd")
                    .format(user.getBirthday()),
                user.getPhone(),
                user.getEmail(),
                user.getGender(),
                user.getRole()
            ))
            .collect(Collectors.toList());
    }

    public List<Competition> applyUserToCompetition( String mail, Integer competition_id){
        Integer user_id = userRepository.findByEmail(mail).get().getId();
        String sql = "insert into competition_users (user_id, competition_id) values (?,?)";
        jdbcTemplate.update(sql, user_id, competition_id);
        return getCompetitions(mail);
    }

    public List<Group> applyUserToGroup( String mail, Integer group_id){
        Integer user_id = userRepository.findByEmail(mail).get().getId();
        String sql = "insert into user_group (user_id, group_id) values (?,?)";
        jdbcTemplate.update(sql, user_id, group_id);
        return getGroups(mail);
    }

    public List<TripResponseDTO> applyUserToTrip( String mail, Integer trip_id){
        Integer user_id = userRepository.findByEmail(mail).get().getId();
        String sql = "insert into trip_users (user_id, trip_id) values (?,?)";
        jdbcTemplate.update(sql, user_id, trip_id);
        return getTrips(mail);
    }

    public Integer getMaxTripDifficulty(String mail){
        Integer user_id = userRepository.findByEmail(mail).get().getId();
        String sql = "select from trip_users where user_id = ?";
        List<Integer> ids = jdbcTemplate.queryForList(sql, Integer.class, user_id);
        String sqlTrips = "select difficulty from trip where id in ? order by difficulty limit 1";
        return jdbcTemplate.queryForObject(sqlTrips, Integer.class, ids);
    }

    public Integer getTripsCount(String mail){
        Integer user_id = userRepository.findByEmail(mail).get().getId();
        String sql = "select count(*) from trip_users where user = ?";
        return  jdbcTemplate.queryForObject(sql, Integer.class, user_id);
    }
}
