create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	expired_date date,
	price float,
	type_id int references type(id)
);

insert into type(name) values('ГPЕЧКА');
insert into type(name) values('МОЛОКО');
insert into type(name) values('СЫР');
insert into type(name) values('НАПИТОК');

insert into product(name, expired_date, price, expired, type_id) values('Гречка Гудвил', '2023-02-24', 87, 1);
insert into product(name, expired_date, price, expired, type_id) values('Гречка зеленая', '2022-02-06', 68, 1);
insert into product(name, expired_date, price, expired, type_id) values('Молоко топленое', '2021-12-24', 35, 2);
insert into product(name, expired_date, price, expired, type_id) values('Молоко Простоквашино', '2021-11-20', 54, 2);
insert into product(name, expired_date, price, expired, type_id) values('Сыр пармезан', '2022-02-06', 560, 3);
insert into product(name, expired_date, price, expired, type_id) values('Сыp российский', '2020-11-14', 35, 3);
insert into product(name, expired_date, price, expired, type_id) values('Лемонад', '2022-12-24', 87, 4);
insert into product(name, expired_date, price, expired, type_id) values('Фанта', '2024-02-06', 68, 4);
insert into product(name, expired_date, price, expired, type_id) values('Квас', '2021-12-02', 35, 4);

select * from product 
where type_id = 3;

select * from product 
where type_id = (select type.id from type where name = 'СЫР');

select * from product 
where name like ('%мороженное%');
select * from product 
where expired_date < current_date;

select * from product
where price in (
select max(price) from product
);

select type.name, count(*)  
from product 
join type 
on type.id = product.type_id 
group by type.name;

select  * from product 
join type 
on type.id = product.type_id 
where type.name = 'МОЛОКО' or type.name = 'СЫР';

select type.name, count(*) from product 
join type 
on type.id = product.type_id 
group by type.name 
having count(type.name) < 10;

select type.name, product.name from product 
join type 
on type.id = product.type_id;



