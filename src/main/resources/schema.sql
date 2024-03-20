create schema homework;

create table homework.CUSTOMERS (
                                    id serial primary key,
                                    name varchar,
                                    surname varchar,
                                    age int,
                                    phone_number int
);

create table homework.ORDERS (
                                 id serial primary key,
                                 date varchar,
                                 customer_id int references homework.customers(id),
                                 product_name varchar,
                                 amount int
);

insert into homework.customers(name, surname, age, phone_number)
values ('Alexey', 'fgjgkls', 32, 5689);

insert into homework.customers(name, surname, age, phone_number)
values ('Masha', 'fgjgkls', 31, 5684);

insert into homework.orders (date, customer_id, product_name, amount)
values ('23.01.2023', 1, 'куртка', 5000);

insert into homework.orders (date, customer_id, product_name, amount)
values ('28.04.2023', 2, 'сапоги', 3000);


