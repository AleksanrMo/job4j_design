create table license(
	id serial primary key,
	number int
);

create table driver(
	id serial primary key,
	name varchar(255),
	age int,
	license_id int references license(id)
);

insert into license(number) values(14567);
insert into license(number) values(67891);
insert into license(number) values(32678);
insert into driver(name, age, license_id) values('Andrey Molokov', 65, 1);
insert into driver(name, age, license_id) values('Zenia Egorov', 25, 2);
insert into driver(name, age, license_id) values('Irina Horosheva', 42, 3);


select l.number, p.name from driver as p join license as l on p.license_id = l.id;
select number Номер_удостовения, name Имя from driver as p join license as l on p.license_id = l.id;
select p.name, p.age, l.number from driver as p join license as l on p.license_id = l.id;

