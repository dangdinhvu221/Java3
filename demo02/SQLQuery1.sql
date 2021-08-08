DROP DATABASE IF EXISTS quan_ly_blog;
GO

CREATE DATABASE quan_ly_blog
GO

USE quan_ly_blog
GO

IF OBJECT_ID('danh_muc') IS NOT NULL
	DROP TABLE danh_muc
go
CREATE TABLE danh_muc
(
    id int IDENTITY(1, 1) PRIMARY KEY,
    ten_danh_muc NVARCHAR(255) NOT NULL,
);

GO

IF OBJECT_ID('bai_viet') IS NOT NULL
	DROP TABLE bai_viet
go
CREATE TABLE bai_viet
(
    id int IDENTITY(1, 1) PRIMARY KEY,
    tieu_de NVARCHAR(255) NOT NULL,
    noi_dung NVARCHAR(50) NOT NULL,
    ngay_tao DATE NOT NULL,
    danh_muc_id int NOT NULL,
    constraint FK_BaiViet_DanhMuc foreign key (danh_muc_id) references danh_muc(id)
);

GO

INSERT INTO danh_muc(ten_danh_muc)
    VALUES
    ('Java'),
    ('PHP');

GO

INSERT INTO bai_viet(tieu_de, noi_dung, ngay_tao, danh_muc_id)
    VALUES
    ('Java ket noi CSDL', N'Sử dụng JDBC', '2020-09-14', 1),
    ('PHP 1', N'Huong doi tuong trong PHP', '2019-04-21', 2),
    ('Java 4', N'Sử dụng JSP', '2020-09-14', 2),
	('Java 4', N'Sử dụng JSP', '2020-09-14', 2);

GO
SELECT*FROM dbo.bai_viet
SELECT*FROM dbo.danh_muc

SELECT*FROM dbo.bai_viet WHERE danh_muc_id = 1
DELETE dbo.bai_viet WHERE danh_muc_id = 1
INSERT dbo.bai_viet(tieu_de, noi_dung, ngay_tao, danh_muc_id)VALUES()
UPDATE dbo.bai_viet SET [tieu_de], [noi_dung] = ?, [ngay_tao] = ?, [danh_muc_id] = ? WHERE [id] = ?
