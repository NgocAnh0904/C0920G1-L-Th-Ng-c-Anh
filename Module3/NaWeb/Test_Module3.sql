Drop database if exists Test_Module3;
create database Test_Module3;
use Test_Module3;

create table benh_an(
benh_an_id int primary key auto_increment,
ngay_nhap_vien date,
ngay_ra_vien date,
lydo_nhapvien varchar(200)
);

create table benh_nhan(
benh_nhan_id int primary key auto_increment,
benh_nhan_name varchar(45)
);
