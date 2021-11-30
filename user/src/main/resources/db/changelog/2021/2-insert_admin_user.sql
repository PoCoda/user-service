--liquibase formatted sql

--changeset hodzinets:2-insert_admin_user

INSERT INTO public.users (username, firstname, lastname, "password")
VALUES ('admin', 'Admin', 'Adminowycz', MD5('admin'));