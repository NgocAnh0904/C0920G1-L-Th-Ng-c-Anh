drop database if exists casestudy;
create database casestudy;
use casestudy;

create table loaikhach (
id_loaikhach int primary key auto_increment,
ten_loaikhach varchar(45)
);

create table khachhang (
id_khachang int primary key auto_increment,
id_loaikhach int,
foreign key (id_loaikhach) references loaikhach (id_loaikhach),
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table kieuthue (
id_kieuthue int primary key auto_increment,
ten_kieuthue varchar(45),
gia int
);

create table loaidichvu (
id_loaidichvu int primary key auto_increment,
ten_loaidichvu varchar(50)
);

create table dichvu (
id_dichvu int primary key auto_increment,
ten_dichvu varchar(45),
dien_tich int,
so_tang int,
so_nguoitoida varchar(45),
chiphi_thue varchar(45),
id_kieuthue varchar(45),
foreign key (id_kieuthue) references kieuthue (id_kieuthue),
id_loaidichvu int,
foreign key (id_loaidichvu) references loaidichvu (id_loaidichvu),
trang_thai varchar(45)
);

create table vitri (
id_vitri int primary key auto_increment,
ten_vitri varchar(45)
);

create table trinhdo (
id_trinhdo int primary key auto_increment,
trinh_do varchar(45)
);

create table bophan (
id_bophan int primary key auto_increment,
ten_bophan varchar(45)
);

create table nhanvien (
id_nhanvien int primary key auto_increment,
ho_ten int,
id_vitri int,
foreign key (id_vitri) references vitri (id_vitri),
id_trinhdo int,
foreign key (id_trinhdo) references trinhdo (id_trinhdo),
id_bophan int,
foreign key (id_bophan) references bophan (id_bophan),
ngay_sinh date,
so_cmtnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table dichvudikem (
id_dichvu_dikem int primary key auto_increment,
ten_dichvu_dikem varchar(45),
gia int,
don_vi int,
trang_thai_khadung varchar(45)
);

create table hopdongchitiet (
id_hopdong_chitiet int primary key auto_increment, 
id_hopdong int,
foreign key (id_hopdong) references hopdong (id_hopdong),
id_dichvu_dikem int,
foreign key (id_dichvu_dikem) references dichvudikem (id_dichvu_dikem),
so_luong int
);

create table hopdong (
id_hopdong int primary key ,
id_nhanvien int,
id_khachhang int,
id_dichvu int,
ngaylam_hopdong date,
ngayketthuc_hopdong date,
tien_datcoc int,
tong_tien int
);

