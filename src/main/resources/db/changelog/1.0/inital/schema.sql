create table "user"
(
    id       varchar(100) not null
        constraint user_id primary key,
    login    varchar(60)  not null,
    password varchar(60)  not null,
    email    varchar(60)
);

create table memo
(
    id        serial                not null
        constraint memo_id primary key,
    status    boolean default false not null,
    order_num int     default 0     not null,
    content   text    default ''    not null,
    user_id   varchar(100)
        constraint memo_user_id_fk
            references "user"
);