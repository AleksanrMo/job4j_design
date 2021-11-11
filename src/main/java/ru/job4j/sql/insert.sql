insert into role(name) values('director');
insert into role(name) values('builder');
insert into role(name) values('accounter');
insert into role(name) values('driver');

insert into users(First_name, Last_name, role_id) values('Alex', 'Ivanov', 1);
insert into users(First_name, Last_name, role_id) values('Irina', 'Alekseeva', 3);
insert into users(First_name, Last_name, role_id) values('Andrey', 'Kozin', 2);
insert into users(First_name, Last_name, role_id) values('Ivan', 'Davidov', 2);
insert into users(First_name, Last_name, role_id) values('Danil', 'Volkov', 4);
insert into users(First_name, Last_name, role_id) values('Alex', 'Ichol', 2);
insert into users(First_name, Last_name, role_id) values('Irina', 'Ragozin', 2);

insert into rules(rule) values('Управляет организацией.');
insert into rules(rule) values('Ходит в столовую.');
insert into rules(rule) values('Работает пять дней в неделю');
insert into rules(rule) values('Имеет права нанять и уволить человека.');
insert into rules(rule) values('Занимается строительством и ремонтом.');
insert into rules(rule) values('Ведет бухгалтерию.');
insert into rules(rule) values('Выдает зарплату рабочим.');
insert into rules(rule) values('Имеет право посещать все корпаративы.');
insert into rules(rule) values('Занимается доставкой груза на объекты.');
insert into rules(rule) values('Развозит работников по домам.');
insert into rules(rule) values('Имеет право на оплачиваемый отпуск.');

insert into ruls_for_role(role_id, rules_is) values(1, 1);
insert into ruls_for_role(role_id, rules_is) values(1, 2);
insert into ruls_for_role(role_id, rules_is) values(1, 3);
insert into ruls_for_role(role_id, rules_is) values(1, 4);
insert into ruls_for_role(role_id, rules_is) values(1, 8);
insert into ruls_for_role(role_id, rules_is) values(1, 11);
insert into ruls_for_role(role_id, rules_is) values(2, 2);
insert into ruls_for_role(role_id, rules_is) values(2, 3);
insert into ruls_for_role(role_id, rules_is) values(2, 5);
insert into ruls_for_role(role_id, rules_is) values(2, 8);
insert into ruls_for_role(role_id, rules_is) values(2, 11);
insert into ruls_for_role(role_id, rules_is) values(3, 2);
insert into ruls_for_role(role_id, rules_is) values(3, 3);
insert into ruls_for_role(role_id, rules_is) values(3, 6);
insert into ruls_for_role(role_id, rules_is) values(3, 8);
insert into ruls_for_role(role_id, rules_is) values(3, 11);
insert into ruls_for_role(role_id, rules_is) values(4, 2);
insert into ruls_for_role(role_id, rules_is) values(4, 3);
insert into ruls_for_role(role_id, rules_is) values(4, 8);
insert into ruls_for_role(role_id, rules_is) values(4, 9);
insert into ruls_for_role(role_id, rules_is) values(4, 10);
insert into ruls_for_role(role_id, rules_is) values(4, 11);

insert into category(importance) values('Низкая');
insert into category(importance) values('Средняя');
insert into category(importance) values('Высдкая');

insert into state(name) values('Принята.');
insert into state(name) values('В процессе.');
insert into state(name) values('Исполнена.');
insert into state(name) values('Отклонина.')

insert into item(name, users_id, category_id, state_id) values('Заявление о повышении.', 3, 1, 2);
insert into item(name, users_id, category_id, state_id) values('Добавить в меню компот.', 2, 2, 1);
insert into item(name, users_id, category_id, state_id) values('Провести корпоратив.', 1, 3, 3);
select * from item;

insert into comments(comment, item_id) values('Ожидаем решение директора', 1);
insert into comments(comment, item_id) values('Заявление будет рассмотренно в речении недели', 2);





