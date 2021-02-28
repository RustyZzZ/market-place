create table products
(
    id bigint not null
        constraint products_pkey
            primary key,
    name varchar(255),
    price numeric(19,2),
    category_id bigint
        constraint fk1cf90etcu98x1e6n9aks3tel3
            references category
);

alter table products owner to postgres;

