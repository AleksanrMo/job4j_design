create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date) values('Crocodile', 21900, null);
insert into fauna(name, avg_age, discovery_date) values('Maratus', 4380, '1877-11-11');
insert into fauna(name, avg_age, discovery_date) values('Tiger', 7300, '1778-01-01');
insert into fauna(name, avg_age, discovery_date) values('Flouner fish', 3650, '1801-01-01' );
insert into fauna(name, avg_age, discovery_date) values('Raven', 23725, null);
insert into fauna(name, avg_age, discovery_date) values('Wildebeest', 5840, '1001-01-01');
insert into fauna(name, avg_age, discovery_date) values('Giraffe', 10950, null);
insert into fauna(name, avg_age, discovery_date) values('Elephant', 25550, null);
insert into fauna(name, avg_age, discovery_date) values('Mountain Gorilla', 18250, '1847-01-01');

select * from fauna where name like ('%fish');
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where  discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';


