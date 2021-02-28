create table category
(
    id bigint not null
        constraint category_pkey
            primary key,
    description varchar(255),
    name varchar(255)
);

alter table category owner to postgres;

