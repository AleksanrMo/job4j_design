create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	devices_id int references devices(id),
	people_id int references people(id)
);
select * from devices_people;
insert into devices(name, price) values('Redmi 9x', 9453);
insert into devices(name, price) values('iPhone 12', 34000);
insert into devices(name, price) values('Honor 12 super', 19993);
insert into devices(name, price) values('Samsung S6j', 13400);
insert into devices(name, price) values('Lenovo 4g', 8300);

insert into people(name) values('Valera');
insert into people(name) values('Igor');
insert into people(name) values('Ivan');
insert into people(name) values('Andrey');
insert into people(name) values('Sergey');

insert into devices_people(people_id, devices_id) values(1, 2);
insert into devices_people(people_id, devices_id) values(2, 4);
insert into devices_people(people_id, devices_id) values(3, 3);
insert into devices_people(people_id, devices_id) values(4, 1);
insert into devices_people(people_id, devices_id) values(5, 5);
insert into devices_people(people_id, devices_id) values(1, 3);
insert into devices_people(people_id, devices_id) values(2, 2);
insert into devices_people(people_id, devices_id) values(3, 4);
insert into devices_people(people_id, devices_id) values(4, 5);
insert into devices_people(people_id, devices_id) values(5, 1);

select avg(price) from devices;

select b.name, avg(c.price)
from devices_people as a
join people as b
on a.people_id = b.id
join devices as c
on a.devices_id = c.id
group by b.name;

select b.name, avg(c.price)
from devices_people as a
join people as b
on a.people_id = b.id
join devices as c
on a.devices_id = c.id
group by b.name
having avg(c.price) > 5000;









