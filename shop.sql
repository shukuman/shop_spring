drop table if exists users, orders, carts, products, orders_products, reviews cascade;

create table users
(
    id serial8,
    role int2               not null,
    first_name varchar(40)  not null,
    last_name varchar(40),
    e_mail varchar(40),
    password varchar(40)    not null,
    primary key (id)
);

create table products
(
    id serial8,
    name varchar(40)          not null,
    price int4                not null,
    primary key (id)
);

create table carts
(
    id serial8,
    user_id int8,
    product_id int8,
    count int8,
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (product_id) references products (id)
);

create table orders
(
    id serial8,
    user_id int8,
    product_id int8,
    status int2,
    order_date date default now(),
    address varchar(40),
    primary key (id),
    foreign key (user_id) references users (id)
);

create table orders_products
(
    id serial8,
    order_id int8,
    product_id int8,
    count int8,
    primary key (id),
    foreign key (order_id) references orders (id),
    foreign key (product_id) references products (id)
);

create table reviews
(
    id serial8,
    user_id int8,
    product_id int8,
    assessment int2,
    comment text,
    status varchar(40)  default 'not published',
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (product_id) references products (id)
);