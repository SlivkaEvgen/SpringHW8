

-- create sequence hibernate_sequence start 1 increment 1;
create type gender as enum ('SEX_MALE','SEX_FEMALE');

CREATE TABLE if not exists role
(
    id   BIGINT NOT NULL primary key,
    name VARCHAR(255)
);
CREATE TABLE if not exists manufacturer
(
    id   BIGINT NOT NULL primary key,
    name VARCHAR(15)
);

CREATE TABLE if not exists users
(
    id        BIGINT primary key NOT NULL,
    name      VARCHAR(15),
    last_name VARCHAR(15),
    gender    gender             NOT NULL,
    email     VARCHAR(20),
    password  VARCHAR(100),
    role_id   bigint
--     active    BOOLEAN
);

CREATE TABLE if not exists product
(
    id              BIGINT NOT NULL primary key,
    name            VARCHAR(15),
    price           DOUBLE PRECISION,
    manufacturer_id BIGINT
);
-- create table if not exists user_roles
-- (
--     user_id  bigint,
--     roles_id bigint
-- );

insert into role(id, name)
VALUES (1, 'ADMIN');
insert into role(id, name)
VALUES (2, 'USER');
insert into role(id, name)
VALUES (3, 'PROD');
insert into role(id, name)
VALUES (4, 'DEV');


-- create users
INSERT INTO users (id, name, last_name, gender, email, password,role_id)
VALUES (1, 'USER', 'USER', 'SEX_MALE', 'yyy@oi', '123',1);
INSERT INTO users (id, name, last_name, gender, email, password,role_id)
VALUES (2, 'ADMIN', 'ADMIN', 'SEX_MALE', 'admin@ua', '123',2);
INSERT INTO users (id, name, last_name, gender, email, password,role_id)
VALUES (3, 'VOVA', 'Ivanov', 'SEX_MALE', 'hhh@ua', '123',3);
-- create manufacturers
INSERT INTO manufacturer (id, name)
VALUES (1, 'Apple');
INSERT INTO manufacturer (id, name)
VALUES (2, 'Samsung');
INSERT INTO manufacturer (id, name)
VALUES (3, 'LG');
INSERT INTO manufacturer (id, name)
VALUES (4, 'Motorola');
-- create products
INSERT INTO product (id, name, price, manufacturer_id)
VALUES (1, 'Iphone', 1799.9, 1);
INSERT INTO product (id, name, price, manufacturer_id)
VALUES (2, 'lii', 890.99, 2);
INSERT INTO product (id, name, price, manufacturer_id)
VALUES (3, 'ljkbn', 1890.99, 3);
INSERT INTO product (id, name, price, manufacturer_id)
VALUES (4, 'kkn', 2290.99, 4);
INSERT INTO product (id, name, price, manufacturer_id)
VALUES (5, 'ggg', 290.99, 1);
-- CREATE USER_ROLES
-- insert into user_roles(user_id, roles_id)
-- VALUES (1, 1),
--        (2, 1),
--        (3, 2);

