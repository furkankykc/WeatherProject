
drop database if exists H2H ;
create database if not exists H2H; 
use H2H;

create table user(
    	id int primary key auto_increment,
    	username varchar(30) unique,
    	password varchar(30),
    	isAdmin boolean
);
insert into user(username,password,isAdmin)  VALUES('root','1234',1);
create table location(
    	id int primary key auto_increment,
    	locationName varchar(30) unique
);
create table log(
	id int primary key auto_increment,
	userId int,
	locationId int,
	time timeStamp,
	ip varchar(30),
	queryTime double,
	resultStatus boolean
	);