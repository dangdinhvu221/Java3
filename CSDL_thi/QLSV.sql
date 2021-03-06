create database QLSV
go
use QLSV
go

create table USERS
(
username nvarchar(50) not null primary key,
upassword nvarchar(30) not null,
chucnang nvarchar(30) not null
)
go

Create table Class
(
	IDClass nvarchar(15) not null primary key,
	NameClass nvarchar(30) not null,
)
go
create table STUDENT
(
Masv nvarchar(10) not null primary key,
Hoten nvarchar(50) not null,
IDClass nvarchar(15) not null,
Ngaysinh datetime,
gioitinh nvarchar(20),
diachi nvarchar(50),
dienthoai nvarchar(15),
Khoanganh nvarchar(30),
loginsv nvarchar(50),
constraint FK_Sinhvien_Class foreign key (IDClass) references Class (IDClass)
)
go



insert into USERS(username,upassword,chucnang) values('HieuTT','123','GV')
insert into USERS(username,upassword,chucnang) values('MaiDTT','456','GV')
insert into USERS(username,upassword,chucnang) values('LoanTT','789','GV')
insert into USERS(username,upassword,chucnang) values('ThuyNT','123','GV')
insert into USERS(username,upassword,chucnang) values('HoaKTM','123','DT')
insert into USERS(username,upassword,chucnang) values('ThuPT','123','DT')
insert into USERS(username,upassword,chucnang) values('AnhPTT','123','DT')
insert into USERS(username,upassword,chucnang) values('sa','123','DT')
go

insert into Class(IDClass,NameClass)values('PT12351-MOB','Lớp 51 MOB khóa 12.3')
insert into Class(IDClass,NameClass)values('PT12353-MOB','Lớp 53 MOB khóa 12.3')
insert into Class(IDClass,NameClass)values('PT12354-MOB','Lớp 54 MOB khóa 12.3')
insert into Class(IDClass,NameClass)values('PT12301-UD','Lớp 01 UD khóa 12.3')
go

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00123',N'Lê Thiện Trung','PT12351-MOB','1983-09-10','Nam',N'Hà nội','09123456789','K12.3-MOB','TrungLTPH00123@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00125',N'Lê Minh Đăng','PT12351-MOB','1985-01-06','Nam',N'Hà nội','09123456218','K12.3-MOB','DangLMPH00125@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00126',N'Lê Xuân Lý','PT12351-MOB','1985-08-07','Nam',N'Hà nội','09123456367','K12.3-MOB','LyLXPH00126@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00127',N'Lê Thu Lan','PT12353-MOB','1985-12-06',N'Nữ',N'Thanh Hóa','09893456218','K12.1-MUL','LanLTPH00127@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00128',N'Trịnh Thảo Phương','PT12353-MOB','1988-01-06',N'Nữ',N'Hà nội','09123459981','K12.1-MUL','PhuongTTPH00128@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00129',N'Trịnh Ngọc Lê','PT12353-MOB','1989-01-15',N'Nữ',N'Hà nội','09123459982','K12.1-MUL','LeTNPH00129@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00229',N'Lê Xuân Quý','PT12353-MOB','1987-06-15',N'Nữ',N'Thanh Hóa','09823459982','K12.1-MUL','QuyLXPH00229@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00165',N'Trần Phương Thảo','PT12354-MOB','1990-09-13',N'Nữ',N'Bắc Giang','09123459989','K12.1-UD','ThaoTPPH00165@fpt.edu.vn')

insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv)
values('PH00166',N'Trần Mai Phương','PT12354-MOB','1990-10-13',N'Nữ',N'Bắc Giang','09123459972','K12.1-UD','MaiTPPH00166@fpt.edu.vn')

go


--DELETE FROM dbo.STUDENT WHERE [Masv] = ?
--insert into STUDENT(Masv,Hoten,IDClass,Ngaysinh,gioitinh,diachi,dienthoai,Khoanganh,loginsv) VALUES ()
--UPDATE dbo.STUDENT SET [Hoten] = ?, [Ngaysinh] = ?, gioitinh = ? WHERE [Masv] = ?

select * from USERS WHERE [username] = 'AnhPTT' AND [upassword] = 123
select * from dbo.Class
select Masv, Hoten, NameClass, gioitinh, dienthoai from dbo.STUDENT JOIN dbo.Class ON Class.IDClass = STUDENT.IDClass