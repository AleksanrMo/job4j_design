-- many-to-one
create table city(
	id serial primary key,
	name varchar(255)
);
create table citizen(
	id serial primary key,
	name varchar(255),
	city_id int references city(id) 
);

-- many-to-many
create table dish(
	id serial primary key,
	name varchar(255)
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table favorite_dish(
	id serial primary key,
	dish_id int references dish(id),
	people_id int references people(id)
);
 
--one-to-one
create table license(
	id serial primary key,
	number int
);

create table driver(
	id serial primary key,
	name varchar(255),
	driver_licensce int references license(id) unique
);

-- many-to-many-unique 
create table driver2(
	id serial primary key,
	name varchar(255)
);

create table driver_license(
	id serial primary key,
	number int
);

create table license_people(
	id serial primary key,
	license_id int references driver_license(id) unique,
	driver_id int references driver2(id) unique
);
select * from license_people;

