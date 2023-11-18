create database movie;
use movie;
create table movie(id integer auto_increment primary key, title varchar(255), genre varchar(255), yearOfRelease integer);
insert into movie(title, genre, yearOfRelease) values ("Marvel 3", "Action", 2018);
insert into movie(title, genre, yearOfRelease) values ("Iron Man 2", "Action", 2010);

select * from movie;