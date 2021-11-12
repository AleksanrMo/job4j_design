create table driver(
	id serial primary key,
	name varchar(255),
	license_id int
);

create table license(
	id serial primary key,
	number int
);
insert into license(number) values(14567);
insert into license(number) values(67891);
insert into license(number) values(32678);
insert into driver(name, license_id) values('Andrey Molokov', 1);
insert into driver(name, license_id) values('Zenia Egorov', 2);
insert into driver(name, license_id) values('Irina Horosheva', 3);

alter table driver add age int;
insert into driver(age);
update driver
set age = 65 where id = 1;
update driver
set age = 25 where id = 2;
update driver
set age = 42 where id = 3;
select * from driver;


select l.number, p.name from driver as p join license as l on p.license_id = l.id;
select number Номер_удостовения, name Имя from driver as p join license as l on p.license_id = l.id;
select p.name, p.age, l.number from driver as p join license as l on p.license_id = l.id;


