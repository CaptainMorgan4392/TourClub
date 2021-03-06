-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE system_user
(
    id         INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    login      VARCHAR NOT NULL,
    password   VARCHAR NOT NULL,
    name       VARCHAR NOT NULL,
    surname    VARCHAR NOT NULL,
    patronymic VARCHAR NOT NULL,
    birthday   DATE    NOT NULL,
    phone      VARCHAR NOT NULL,
    email      VARCHAR NOT NULL,
    gender     VARCHAR,
    role       VARCHAR NOT NULL,

    CHECK (length(name) <= 20)
);

CREATE TABLE sport
(
    id   INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR NOT NULL
);

CREATE TABLE supervisor
(
    id             INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    system_user_id INT NOT NULL,

    FOREIGN KEY (system_user_id) REFERENCES system_user (id)
);

CREATE TABLE coach
(
    id             INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    system_user_id INT NOT NULL,

    FOREIGN KEY (system_user_id) REFERENCES system_user (id)
);

CREATE TABLE section
(
    id               INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    sport_id         INT NOT NULL,
    supervisor_id    INT NOT NULL,
    max_in_group     INT NOT NULL,
    number_of_groups INT NOT NULL,

    FOREIGN KEY (sport_id) REFERENCES sport (id),
    FOREIGN KEY (supervisor_id) REFERENCES supervisor (id)
);

CREATE TABLE section_group
(
    id        INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    number    VARCHAR NOT NULL,
    name      VARCHAR NOT NULL,
    sport_id  INT     NOT NULL,
    coach_id  INT     NOT NULL,
    timetable VARCHAR NOT NULL,

    FOREIGN KEY (sport_id) REFERENCES sport (id),
    FOREIGN KEY (coach_id) REFERENCES coach (id)
);

CREATE TABLE user_group
(
    id       INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    user_id  INT NOT NULL,
    group_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES system_user (id),
    FOREIGN KEY (group_id) REFERENCES section_group (id)
);

CREATE TABLE group_coach
(
    id       INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    group_id INT NOT NULL,
    coach_id INT NOT NULL,

    FOREIGN KEY (group_id) REFERENCES section_group (id),
    FOREIGN KEY (coach_id) REFERENCES coach (id)
);

CREATE TABLE route
(
    id   INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR NOT NULL
);

CREATE TABLE stop_point
(
    id   INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR NOT NULL
);

CREATE TABLE route_stop_points
(
    id            INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    route_id      INT NOT NULL,
    stop_point_id INT NOT NULL,

    FOREIGN KEY (route_id) REFERENCES route (id),
    FOREIGN KEY (stop_point_id) REFERENCES stop_point (id)
);

CREATE TABLE trip
(
    id               INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name             VARCHAR NOT NULL,
    date             DATE    NOT NULL,
    category         VARCHAR NOT NULL,
    route_id         INT     NOT NULL,
    days_count       INT     NOT NULL,
    difficulty       INT     NOT NULL,
    max_participants INT     NOT NULL,
    type             VARCHAR NOT NULL,
    physical_level   VARCHAR NOT NULL,
    gid              INT     NOT NULL,

    FOREIGN KEY (route_id) REFERENCES route (id),
    FOREIGN KEY (gid) REFERENCES system_user (id)
);

CREATE TABLE trip_users
(
    id      INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    trip_id INT NOT NULL,
    user_id INT NOT NULL,

    FOREIGN KEY (trip_id) REFERENCES trip (id),
    FOREIGN KEY (user_id) REFERENCES system_user (id)
);

CREATE TABLE competition
(
    id         INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name       VARCHAR NOT NULL,
    sport      INT     NOT NULL,
    date       DATE    NOT NULL,
    place      VARCHAR NOT NULL,
    payment    INT     NOT NULL,
    supervisor INT     NOT NULL,

    FOREIGN KEY (sport) REFERENCES sport (id),
    FOREIGN KEY (supervisor) REFERENCES supervisor (id)
);

CREATE TABLE competition_users
(
    id             INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    competition_id INT NOT NULL,
    user_id        INT NOT NULL,

    FOREIGN KEY (competition_id) REFERENCES competition (id),
    FOREIGN KEY (user_id) REFERENCES system_user (id)
);
