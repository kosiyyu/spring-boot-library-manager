CREATE SEQUENCE IF NOT EXISTS book_seq;

CREATE TABLE IF NOT EXISTS book (
book_id BIGINT NOT NULL DEFAULT nextval('book_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
borrowed BOOLEAN NOT NULL,
published DATE,
publisher VARCHAR(255) NOT NULL,
description VARCHAR(500) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS author_seq;

CREATE TABLE IF NOT EXISTS author (
author_id BIGINT NOT NULL DEFAULT nextval('author_seq') PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
birthday DATE
);

--NO SEQUENCE HERE

CREATE TABLE IF NOT EXISTS book_author(
book_id BIGINT REFERENCES book,
author_id BIGINT REFERENCES author
);

CREATE SEQUENCE IF NOT EXISTS user_seq;

CREATE TABLE IF NOT EXISTS user_ (
	user_id BIGINT NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
	username varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
    enabled boolean NOT NULL,
	role varchar(100)
);