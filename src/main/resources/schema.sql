DROP TABLE IF EXISTS user_roles cascade;
DROP TABLE IF EXISTS votes cascade;
DROP TABLE IF EXISTS dishes cascade;
DROP TABLE  IF EXISTS restaurants cascade;
DROP TABLE IF EXISTS users cascade;
DROP SEQUENCE  IF EXISTS global_seq;

create sequence global_seq start with 1;

create table users
(
    id                      integer default global_seq.nextval      primary key,
    name                    varchar                                 not null,
    password                varchar                                 not null,
    registered              timestamp default now()                 not null,
    enabled                 bool default true                       not null
);
create unique index users_unique_idx on users (name);

create table user_roles
(
    user_id                 integer                                 not null,
    role                    varchar,
    constraint user_roles_idx unique (user_id, role),
    foreign key (user_id) references users (id) on delete cascade
);

create table restaurants
(
    id                      integer default global_seq.nextval      primary key,
    name                    varchar                                 not null,
    description             varchar                                 not null
);

create table dishes
(
    id                      integer default global_seq.nextval      primary key,
    name                    varchar                                 not null,
    price                   bigint                                  not null,
    restaurant_id           integer                                 not null,
    constraint dishes_idx unique (name, restaurant_id),
    foreign key (restaurant_id) references restaurants (id) on delete cascade
);

create table votes
(
    id                      integer default global_seq.nextval      primary key,
    user_id                 integer                                 not null,
    restaurant_id           integer                                 not null,
    date_vote               timestamp default now()                 not null,
    constraint user_votes unique (user_id,  date_vote),
    foreign key (user_id) references users (id) on delete cascade,
    foreign key (restaurant_id) references restaurants (id) on delete cascade
)