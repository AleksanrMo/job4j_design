create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(name) values('Van'),
('Sedan'),
('Coupe'),
('HatchBack'),
('Minivan'),
('Pickup');
insert into engine(name) values('Diesel'),
('Oil_engine'),
('Electric_engine'),
('Hibrid');
insert into transmission(name) values('Automat'),
('Manual');

insert into car(name, body_id, engine_id, transmission_id) values('Tesla', 2, 3, 1);
insert into car(name, body_id, engine_id, transmission_id) values('Audi', 3, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Toyota', 4, 4, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Ford', 6, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Niva', 4, 2, 2);

select c.name car, b.name body, e.name engine, t.name transmissiln 
from car c join body b 
on b.id = c.body_id
join engine e on e.id = c.engine_id 
join transmission t on t.id = c.transmission_id;


select * from body b left join car c on c.body_id = b.id where c.body_id is null;
select * from engine e left join car c on c.engine_id = e.id where c.engine_id is null;
select * from transmission t left join car c on c.transmission_id = t.id where c.transmission_id is null;
