--liquibase formatted sql

--changeset hodzinets:3-add_user_city

ALTER TABLE public.users
ADD COLUMN city varchar(255);

UPDATE public.users
SET city = 'KRAKOW';