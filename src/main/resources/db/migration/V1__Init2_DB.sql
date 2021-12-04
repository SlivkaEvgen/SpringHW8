-- create sequence hibernate_sequence start 1 increment 1;
create type gender as enum ('SEX_MALE','SEX_FEMALE');

create table if not exists role
(
    id   varchar(20) not null primary key,
    name varchar(20)
);

create table if not exists manufacturer
(
    id   varchar(20) not null primary key,
    name varchar(15)
);

create table if not exists users
(
    id        varchar(20) primary key not null,
    name      varchar(15),
    last_name varchar(15),
    gender    gender                  not null,
    email     varchar(20),
    password  varchar(100),
    role_id   varchar(20)
);

create table if not exists product
(
    id              varchar(20) not null primary key,
    name            varchar(15),
    price           double precision,
    manufacturer_id varchar(20)
);

-- create roles
insert into role(id, name)
values ('1', 'ADMIN'),
       ('2', 'USER'),
       ('3', 'PROD'),
       ('4', 'DEV');

-- create users
insert into users (id, name, last_name, gender, email, password, role_id)
values ('1', 'USER', 'USER', 'SEX_MALE', 'yyy@oi', '123', '1'),
       ('2', 'ADMIN', 'ADMIN', 'SEX_MALE', 'admin@ua', '123', '2'),
       ('3', 'VOVA', 'Ivanov', 'SEX_MALE', 'hhh@ua', '123', '3');

-- create manufacturers
insert into manufacturer (id, name)
values ('1', 'Apple'),
       ('2', 'Samsung'),
       ('3', 'LG'),
       ('4', 'Motorola');

-- create products
insert into product (id, name, price, manufacturer_id)
values ('1', 'Iphone', 1799.9, '1'),
       ('2', 'lii', 890.99, '2'),
       ('3', 'ljkbn', 1890.99, '3'),
       ('4', 'kkn', 2290.99, '4'),
       ('5', 'ggg', 290.99, '1');


