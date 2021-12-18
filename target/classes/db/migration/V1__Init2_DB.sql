-- create sequence hibernate_sequence start 1 increment 1;

-- create types Gender / Roles
create type gender as enum ('MALE','FEMALE');
create type roles as enum ('ROLE_ADMIN','ROLE_USER');

-- create table manufacturer
create table if not exists manufacturer
(
    id   varchar(20) primary key,
    name varchar(15)
);

-- create table users
create table if not exists users
(
    id        varchar primary key,
    name      varchar(15),
    last_name varchar(15),
    gender    varchar,
    email     varchar(20),
    password  varchar(100)
);

-- create table product
create table if not exists product
(
    id              varchar(20) primary key,
    name            varchar(15),
    price           double precision,
    manufacturer_id varchar(20)
);

-- create table user_role
create table user_role
(
    user_id  varchar not null ,
    roles varchar not null,
    primary key (user_id, roles)
);

-- create manufacturers
insert into manufacturer (id, name)
values ('1', 'APPLE'),
       ('2', 'SAMSUNG'),
       ('3', 'LG'),
       ('4', 'MOTOROLA');

-- create products
insert into product (id, name, price, manufacturer_id)
values ('1', 'IPHONE X', 1099.9, '1'),
       ('2', 'TV 52', 1290.99, '2'),
       ('3', 'MICROWAVE', 490.99, '3'),
       ('4', 'PHONE XR', 1190.99, '4'),
       ('5', 'IPOD', 1290.99, '1'),
       ('6', 'MAC AIR', 2290.99, '1'),
       ('7', 'MAC PRO', 2490.99, '1');

-- create users
insert into users (id, name, last_name, gender, email, password)
values ('1', 'ADMIN', 'ADMIN', 'MALE', 'admin@ua', '$2a$10$2Sy0K/rQTxX1flzOt0Z62.Z8JLal6NPCDI09ELDViGYuDCD4ceoGG'),
       ('2', 'USER', 'USER', 'MALE', 'user@ua', '$2a$10$/5aMIjIbWnFOUgdVHoFGpOkcjubz8wOXYy8hzbKoyQVFcIiYY7z7i'),
       ('3', 'VOVA', 'VOVA', 'MALE', 'vova@ua', '$2a$10$e4laZ8QwdzYzKmsWgLMM8.kl6soxQkRvkjQgGXm4r4OLDhXL1ekJO'),
       ('4', 'GEKA', 'GK', 'MALE', 'geka@ua', '$2a$10$EuHVHqfXs.AqDfmlos9AfuOSs2DsHIhJ2t74CZxyJ95h1gOVkolD6'),
       ('5', 'GEKA2', 'GekK', 'MALE', 'geka2@ua', '$2a$10$EuHVHqfXs.AqDfmlos9AfuOSs2DsHIhJ2t74CZxyJ95h1gOVkolD6');

-- create user_role
insert into user_role(user_id, roles)
values ('1', 'ROLE_ADMIN'),
       ('2', 'ROLE_USER'),
       ('3', 'ROLE_USER'),
       ('4', 'ROLE_USER'),
       ('5', 'ROLE_USER');