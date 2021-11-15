create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments(name) values('d_1'),
('d_2'),
('d_3'),
('d-4'),
('d-5'),
('d-6');

insert into employees(name, departments_id) values ('Andrey', 5),
('Olga', 2),
('Evgeniy', 5),
('Ivan', 3),
('Aleksandr', 1),
('Igor', 4),
('Roman', 5),
('Oleg', 4),
('Anna', 1),
('Sergey', 5);
insert into employees(name) values('Marina');

select * from departments d 
left join employees e 
on d.id = e.departments_id; 

select * from departments d
right join employees e 
on d.id = e.departments_id; 

select * from departments d 
full join employees e 
on d.id = e.departments_id;

select * from departments d 
cross join employees e;

select * from departments d 
left join employees e 
on d.id = e.departments_id
where e.name is null;


select d.name  department, e.name employee  from departments d
right join employees e
on d.id = e.departments_id;

select d.name department , e.name employee  from employees e
left join departments d
on d.id= e.departments_id;


create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values('Petr', 'male'),
('Kristina', 'female'),
('Olga', 'female'),
('Boris', 'male'),
('Ludmila', 'female'),
('Pavel', 'male'),
('Denis' , 'male'),
('Irina', 'female'),
('Polina', 'female');

select *  from teens t1 
cross join teens t2 
where t1.name != t2.name and t1.gender != t2.gender; 
















