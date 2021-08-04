CREATE DATABASE PolyApp
GO
USE PolyApp
GO

IF OBJECT_ID('USERS') IS NOT NULL
	DROP TABLE USERS
GO 
CREATE TABLE USERS
(
	Username VARCHAR(50) NOT NULL PRIMARY KEY(Username),
	[Password] VARCHAR(50)  NULL,
	[Role] NVARCHAR(50) NULL
)
GO

IF OBJECT_ID('STUDENT') IS NOT NULL
	DROP TABLE STUDENT
GO 
CREATE TABLE STUDENT
(
	CodeStudent VARCHAR(7) NOT NULL PRIMARY KEY(CodeStudent),
	Fullname NVARCHAR(50)  NULL,
	Email VARCHAR(50)  NULL,
	PhoneNumber VARCHAR(11) NULL,
	Gender NVARCHAR(5) NULL,
	[Address] NVARCHAR(50) NULL,
	Images NVARCHAR(MAX) NULL
)
GO

IF OBJECT_ID('GRADE') IS NOT NULL
	DROP TABLE GRADE
GO 
CREATE TABLE GRADE
(
	ID INT IDENTITY(1,1) NOT NULL PRIMARY KEY(ID),
	Fullname NVARCHAR(50)  NULL,
	CodeStudent VARCHAR(7) NULL,
	English FLOAT NULL,
	Informationtics FLOAT NULL,
	GDTC FLOAT NULL
	CONSTRAINT FK_GRADE_STUDENT FOREIGN KEY(CodeStudent) REFERENCES dbo.Student
)
GO


INSERT dbo.USERS
		VALUES
		(   'admin', -- Username - varchar(50)
			'admin', -- Password - varchar(50)
			N'true' -- Role - nvarchar(50)
			),
			(   'vuddph14036', -- Username - varchar(50)
			'123', -- Password - varchar(50)
			N'true' -- Role - nvarchar(50)
			),
			(   'vu123', -- Username - varchar(50)
			'123', -- Password - varchar(50)
			N'true' -- Role - nvarchar(50)
			)
SELECT*FROM dbo.USERS
SELECT*FROM dbo.STUDENT
SELECT*FROM dbo.GRADE

select Username, Password from dbo.USERS WHERE Username='admin' AND Password ='admin'
UPDATE dbo.STUDENT
SET Fullname = N'Vũ', Email = '@gmail.com', PhoneNumber = '0123', Gender = N'nữ', Address = N'HN', Images = null
WHERE CodeStudent = 'a';

SELECT Fullname FROM dbo.STUDENT
WHERE Fullname LIKE N'đặng đình vũ'