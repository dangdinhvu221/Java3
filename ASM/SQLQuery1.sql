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
	GDTC FLOAT NULL,
	DTB FLOAT NULL
	CONSTRAINT FK_GRADE_STUDENT FOREIGN KEY(CodeStudent) REFERENCES dbo.Student
)
GO


INSERT dbo.USERS
		VALUES
		(   'admingv', -- Username - varchar(50)
			'123', -- Password - varchar(50)
			N'Giáo viên' -- Role - nvarchar(50)
			),
			(   'admindt', -- Username - varchar(50)
			'123', -- Password - varchar(50)
			N'Đào tạo' -- Role - nvarchar(50)
			),
			(   'admin', -- Username - varchar(50)
			'123', -- Password - varchar(50)
			N'true' -- Role - nvarchar(50)
			)
SELECT*FROM dbo.USERS
SELECT*FROM dbo.STUDENT
SELECT*FROM dbo.GRADE

---
IF OBJECT_ID('Delete_SV_GR') IS NOT NULL
	DROP PROC Delete_SV_GR
GO
CREATE PROC Delete_SV_GR
	@codeStudent VARCHAR(7)
AS	
	BEGIN TRY
	BEGIN TRAN
		DELETE FROM dbo.GRADE 
			WHERE CodeStudent IN (SELECT CodeStudent FROM dbo.GRADE WHERE CodeStudent = @codeStudent)
		DELETE FROM dbo.STUDENT 
			WHERE CodeStudent IN (SELECT CodeStudent FROM dbo.STUDENT WHERE CodeStudent = @codeStudent)
	COMMIT TRAN
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
	END CATCH
--- gọi
EXEC dbo.Delete_SV_GR @codeStudent = 'ph14036'

-----
