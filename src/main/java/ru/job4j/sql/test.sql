CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into person(id, name, company_id) values(1, 'alex', 1);
insert into person(id, name, company_id) values(2, 'alexw', 2);
insert into person(id, name, company_id) values(3, 'alex', 3);
insert into person(id, name, company_id) values(4, 'alexw', 4);
insert into person(id, name, company_id) values(5, 'alex', 5);
insert into person(id, name, company_id) values(7, 'alexw', 6);
insert into person(id, name, company_id) values(8, 'alex', 1);
insert into person(id, name, company_id) values(9, 'alexw', 1);
insert into person(id, name, company_id) values(10, 'alex', 3);
insert into person(id, name, company_id) values(11, 'alexw', 3);
insert into person(id, name, company_id) values(12, 'alex', 5);
insert into person(id, name, company_id) values(13, 'alexw', 6);

insert into company(id, name) values(1, 'A');
insert into company(id, name) values(2, 'B');
insert into company(id, name) values(3, 'C');
insert into company(id, name) values(4, 'D');
insert into company(id, name) values(5, 'E');
insert into company(id, name) values(6, 'F');
select * from company;
select * from person;

select a.name as n, b.name 
as com from person a join company b 
on b.id = a.company_id
where b.id !=5;

select b.name, count(*) as coun
from person a join company b on b.id = a.company_id
group by  b.name
having count(*) = (select count(*)
from company a left join person b
on b.company_id = a.id
group by a.name
order by count(*) desc
limit 1); 







