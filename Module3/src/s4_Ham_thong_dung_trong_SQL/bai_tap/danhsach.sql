drop database if exists sudungham;
create database sudungham;
use sudungham;

create table danhsach (
id int primary key auto_increment,
ten varchar(45),
tuoi int,
khoa_hoc varchar(45),
so_tien int
); 