package com.example.tourclub.service;

import com.example.tourclub.dto.*;
import com.example.tourclub.entity.*;
import com.example.tourclub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableTransactionManagement
public class AdminService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoutePointRepository routePointRepository;


    public List<TripResponseDTO> getTrips() {
        return tripRepository.findAll()
            .stream()
            .map(trip -> new TripResponseDTO(trip))
            .collect(Collectors.toList());
    }

    public List<TripResponseDTO> createTrip(TripDTO tripDTO) {
        tripRepository.save(new Trip(tripDTO));

        return tripRepository.findAll()
            .stream()
            .map(trip -> new TripResponseDTO(trip))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<TripResponseDTO> updateTrip(TripDTO tripDTO) {
        Optional<Trip> foundTrip = tripRepository.findById(tripDTO.getId());

        if (foundTrip.isPresent()) {
            Trip trip = foundTrip.get();

            trip.setName(tripDTO.getName());
            trip.setDate(tripDTO.getDate());
            trip.setCategory(tripDTO.getCategory());
            trip.setRouteId(tripDTO.getRouteId());
            trip.setDaysCount(tripDTO.getDaysCount());
            trip.setDifficulty(tripDTO.getDifficulty());
            trip.setMaxParticipants(tripDTO.getMaxParticipants());
            trip.setType(tripDTO.getType());
            trip.setPhysicalLevel(tripDTO.getPhysicalLevel());
            trip.setGid(tripDTO.getGid());
        }

        return tripRepository.findAll()
            .stream()
            .map(it -> new TripResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<TripResponseDTO> deleteTrip(Integer id) {
        tripRepository.deleteById(id);

        return tripRepository.findAll()
            .stream()
            .map(trip -> new TripResponseDTO(trip))
            .collect(Collectors.toList());
    }







    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
            .stream()
            .map(user -> new UserResponseDTO(user))
            .collect(Collectors.toList());
    }

    public List<UserResponseDTO> createUser(UserDTO userDTO) {
        userRepository.save(new User(userDTO));

        return userRepository.findAll()
            .stream()
            .map(user -> new UserResponseDTO(user))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<UserResponseDTO> updateUser(UserDTO userDTO) {
        Optional<User> foundUser = userRepository.findById(userDTO.getId());

        if (foundUser.isPresent()) {
            User user = foundUser.get();

            user.setLogin(userDTO.getLogin());
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setPatronymic(userDTO.getPatronymic());
            user.setBirthday(userDTO.getBirthday());
            user.setPhone(userDTO.getPhone());
            user.setEmail(userDTO.getEmail());
            user.setGender(userDTO.getGender());
            user.setRole(userDTO.getRole());
        }

        return userRepository.findAll()
            .stream()
            .map(it -> new UserResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<UserResponseDTO> deleteUser(Integer id) {
        userRepository.deleteById(id);

        return userRepository.findAll()
            .stream()
            .map(user -> new UserResponseDTO(user))
            .collect(Collectors.toList());
    }



    /*competition.setId(competitionDTO.getId());
        competition.setName(competitionDTO.getName());
        competition.setSport(competitionDTO.getSport());
        competition.setDate(competitionDTO.getDate());
        competition.setPlace(competitionDTO.getPlace());
        competition.setPayment(competitionDTO.getPayment());
        competition.setSupervisor(competitionDTO.getSupervisor());*/


    public List<CompetitionResponseDTO> getCompetitions() {
        return competitionRepository.findAll()
            .stream()
            .map(it -> new CompetitionResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<CompetitionResponseDTO> createCompetition(CompetitionDTO competitionDTO) {
        competitionRepository.save(new Competition(competitionDTO));

        return competitionRepository.findAll()
            .stream()
            .map(it -> new CompetitionResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<CompetitionResponseDTO> updateCompetition(CompetitionDTO competitionDTO) {
        Optional<Competition> foundCompetition = competitionRepository.findById(competitionDTO.getId());

        if (foundCompetition.isPresent()) {
            Competition competition = foundCompetition.get();

            competition.setId(competitionDTO.getId());
            competition.setName(competitionDTO.getName());
            competition.setSport(competitionDTO.getSport());
            competition.setDate(competitionDTO.getDate());
            competition.setPlace(competitionDTO.getPlace());
            competition.setPayment(competitionDTO.getPayment());
            competition.setSupervisor(competitionDTO.getSupervisor());
        }

        return competitionRepository.findAll()
            .stream()
            .map(it -> new CompetitionResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<CompetitionResponseDTO> deleteCompetition(Integer id) {
        competitionRepository.deleteById(id);

        return competitionRepository.findAll()
            .stream()
            .map(it -> new CompetitionResponseDTO(it))
            .collect(Collectors.toList());
    }






    public List<GroupResponseDTO> getGroups() {
        return groupRepository.findAll()
            .stream()
            .map(it -> new GroupResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<GroupResponseDTO> createGroup(GroupDTO groupDTO) {
        groupRepository.save(new Group(groupDTO));

        return groupRepository.findAll()
            .stream()
            .map(it -> new GroupResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<GroupResponseDTO> updateGroup(GroupDTO groupDTO) {
        Optional<Group> foundGroup = groupRepository.findById(groupDTO.getId());

        if (foundGroup.isPresent()) {
            Group group = foundGroup.get();

            group.setId(groupDTO.getId());
            group.setNumber(groupDTO.getNumber());
            group.setName(groupDTO.getName());
            group.setSportId(groupDTO.getSport());
            group.setCoachId(groupDTO.getCoach());
            group.setTimetable(groupDTO.getTimetable());
        }

        return groupRepository.findAll()
            .stream()
            .map(it -> new GroupResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<GroupResponseDTO> deleteGroup(Integer id) {
        groupRepository.deleteById(id);

        return groupRepository.findAll()
            .stream()
            .map(it -> new GroupResponseDTO(it))
            .collect(Collectors.toList());
    }






    public List<RoutePointResponseDTO> getRoutePoints() {
        return routePointRepository.findAll()
            .stream()
            .map(it -> new RoutePointResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<RoutePointResponseDTO> createRoutePoint(RoutePointDTO routePointDTO) {
        routePointRepository.save(new RoutePoint(routePointDTO));

        return routePointRepository.findAll()
            .stream()
            .map(it -> new RoutePointResponseDTO(it))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<RoutePointResponseDTO> updateRoutePoint(RoutePointDTO routePointDTO) {
        Optional<RoutePoint> foundRoutePoint = routePointRepository.findById(routePointDTO.getId());

        if (foundRoutePoint.isPresent()) {
            RoutePoint routePoint = foundRoutePoint.get();

            routePoint.setId(routePointDTO.getId());
            routePoint.setName(routePointDTO.getName());
        }

        return routePointRepository.findAll()
            .stream()
            .map(it -> new RoutePointResponseDTO(it))
            .collect(Collectors.toList());
    }

    public List<RoutePointResponseDTO> deleteRoutePoint(Integer id) {
        routePointRepository.deleteById(id);

        return routePointRepository.findAll()
            .stream()
            .map(it -> new RoutePointResponseDTO(it))
            .collect(Collectors.toList());
    }

}
