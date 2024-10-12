drop table if exists users, categories, products, specifications, values, carts, orders, orders_products, reviews cascade;

create table users
(
    id          serial8,
    role        int2,
    first_name  varchar(40) not null,
    last_name   varchar(40) not null,
    e_mail      varchar(40) not null,
    password    varchar(40) not null,
    primary key (id)
);

create table categories
(
    id                  serial8,
    category_name       varchar(40) not null,
    primary key (id),
    unique (category_name)
);

create table products
(
    id                  serial8,
    category_id         int8 not null,
    product_name        varchar(40) not null,
    price               int4 not null,
    primary key (id),
    foreign key (category_id) references categories (id),
    unique (product_name)
);

create table specifications
(
    id                  serial8,
    category_id         int4 not null,
    specification_name  varchar(40) not null,
    primary key (id),
    foreign key (category_id) references categories (id),
    unique (category_id, specification_name)
);

create table values
(
    id serial8,
    specification_id int4 not null,
    product_id int4 not null,
    value_name varchar(40) not null,
    primary key (id),
    foreign key (specification_id) references specifications (id),
    foreign key (product_id) references products (id)
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
    status boolean default false,
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (product_id) references products (id)
);

update categories
set
    category_name = 'Computers'
WHERE
    id = 3;

insert into specifications (category_id, specification_name)
values (1, 'Manufacturer'),
       (1, 'Operating system'),
       (1, 'Memory'),
       (1, 'Color');


insert into values (specification_id, product_id, value_name)
values (5, 1, 'Google'),
       (6, 1, 'Android'),
       (7, 1, '512GB'),
       (8, 1, 'Silver');

insert into users (role, first_name, last_name, e_mail, password)
values (1, 'admin', 'admin', 'admin@gmail.com', 'admin'),
       (2, 'Jack', 'Smith', 'jack@gmail.com', 'jack123'),
       (2, 'Bob', 'Dann', 'bob@gmail.com', 'bob777'),
       (2, 'Mary', 'Gold', 'mary@gmail.com', 'mary456');

insert into reviews (user_id, product_id, assessment, comment, status)
values (1, 1, 5, 'Awesome!!!', true),
       (2, 1, 4, 'Good!', false),
       (3, 1, 4, 'Best buy', true),
       (4, 1, 4, 'Quality product', true);

update reviews
set
    status = false
WHERE
    id = 1;

delete from carts
where id = 1;

select p.id,
       c.category_name,
       p.product_name,
       s.specification_name,
       v.value_name
from products p
         join values v on p.id = v.product_id
         join specifications s on s.id = v.specification_id
         join categories c on c.id = p.category_id
order by p.id, specification_id;

select p.id,
       p.product_name,
       r.comment
from products p
join reviews r on p.id = r.product_id where status = true;

select r.comment, r.product_id
from reviews r where r.product_id = 1 and r.status = true;

insert into carts (user_id, product_id, count)
values (2, 2, 1);