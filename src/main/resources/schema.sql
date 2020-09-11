drop table if exists roles CASCADE;
drop table if exists users CASCADE;
drop table if exists users_roles CASCADE;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1000 increment by 1;

create table users (
    id bigint not null,
    username varchar(255),
    login varchar(255),
    password varchar(255),
    primary key (id));

insert into users (id, username, login, password)
    values (1, 'User', 'user', 'User123'),
           (2, 'Admin', 'admin', 'Admin777');

create table roles (
    id bigint not null,
    role varchar(255),
    primary key (id));

insert into roles(id, role)
    values (1, 'guest'),
           (2, 'user'),
           (3, 'admin');

create table users_roles (
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id));

insert into users_roles(user_id, role_id)
    VALUES (1, 1),
           (2, 2);

alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles;
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users;