drop database if exists casestudy;
create database casestudy;
use casestudy;

create table loaikhach (
id_loaikhach int primary key,
ten_loaikhach varchar(45)
);

create table khachhang (
id_khachang int primary key,
id_loaikhach int, 
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table kieuthue (
id_kieuthue int,
ten_kieuthue varchar(45),
gia int
);

create table loaidichvu (
id_loaidichvu int,
ten_loaidichvu varchar(50)
);

create table dichvu (
id_dichvu int,
ten_dichvu varchar(45),
dien_tich int,
so_tang int,
so_nguoitoida varchar(45),
chiphi_thue varchar(45),
id_kieuthue varchar(45),
id_loaidichvu int,
trang_thai varchar(45)
);

create table vitri (
id_vitri int,
ten_vitri varchar(45)
);

create table trinhdo (
id_trinhdo int,
trinh_do varchar(45)
);

create table bophan (
id_bophan int,
ten_bophan varchar(45)
);

create table nhanvien (
id_nhanvien int,
ho_ten int,
id_vitri int,
id_trinhdo int,
id_bophan int,
ngay_sinh date,
so_cmtnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table dichvudikem (
id_dichvu_dikem int,
ten_dichvu_dikem varchar(45),
gia int,
don_vi int,
trang_thai_khadung varchar(45)
);

create table hopdongchitiet (
id_hopdong_chitiet int,
id_hopdong int,
id_dichvu_dikem int,
so_luong int
);

create table hopdong (
id_hopdong int,
id_nhanvien int,
id_khachhang int,
id_dichvu int,
ngaylam_hopdong date,
ngayketthuc_hopdong date,
tien_datcoc int,
tong_tien int
);

