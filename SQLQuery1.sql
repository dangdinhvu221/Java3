DROP DATABASE IF EXISTS quan_ly_mon_hoc;
GO

CREATE DATABASE quan_ly_mon_hoc;
GO

USE quan_ly_mon_hoc;
GO
IF OBJECT_ID('chuyen_nganh') IS NOT NULL
	DROP TABLE dbo.chuyen_nganh
go
CREATE TABLE chuyen_nganh
(
    id int IDENTITY(1, 1) PRIMARY KEY,
    ten_chuyen_nganh NVARCHAR(255) NOT NULL,
);

GO

IF OBJECT_ID('mon_hoc') IS NOT NULL
	DROP TABLE dbo.mon_hoc
go
CREATE TABLE mon_hoc
(
    id int IDENTITY(1, 1) PRIMARY KEY,
    ten_mon_hoc NVARCHAR(255) NOT NULL,
    ma_mon_hoc NVARCHAR(255) NOT NULL,
    ngay_tao DATE NOT NULL,
    chuyen_nganh_id int NOT NULL,
    constraint FK_BaiViet_DanhMuc foreign key (chuyen_nganh_id) references chuyen_nganh(id)
);
GO

INSERT INTO chuyen_nganh(ten_chuyen_nganh)
    VALUES
    ('UDPM'),
    ('TKTW');

GO

INSERT INTO mon_hoc(ten_mon_hoc, ma_mon_hoc, ngay_tao, chuyen_nganh_id)
    VALUES
    ('Java 3', 'SOF203', '2020-09-14', 1),
    ('PHP 3', 'WEB4012', '2019-04-21', 2),
    ('Java 2', 'MOB1023', '2020-09-14', 1),
	('CSDL', 'COM2034', '2020-01-14', 2)

GO
SELECT*FROM dbo.chuyen_nganh
select*from mon_hoc JOIN dbo.chuyen_nganh ON chuyen_nganh.id = mon_hoc.chuyen_nganh_id
WHERE ten_chuyen_nganh = 'UDPM'