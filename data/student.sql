create table student(
	id serial primary key,
	name text,
	cours integer,
	date_of_birth date
);
insert into student(name, cours, date_of_birth) values ('Alex', 2, '1999-03-23');
update student set cours = 3;
select * from student;
delete from student;