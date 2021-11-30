--liquibase formatted sql

--changeset hodzinets:1-add_users_table

CREATE TABLE public.users (
	id bigserial NOT NULL,
	username varchar(255) NOT NULL UNIQUE,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);