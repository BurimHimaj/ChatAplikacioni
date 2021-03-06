USE [master]
GO
/****** Object:  Database [Klienti]    Script Date: 3/25/2018 11:30:57 PM ******/
CREATE DATABASE [Klienti]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Klienti', FILENAME = N'D:\DB\Klienti.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Klienti_log', FILENAME = N'D:\DB\Klienti_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Klienti] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Klienti].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Klienti] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Klienti] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Klienti] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Klienti] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Klienti] SET ARITHABORT OFF 
GO
ALTER DATABASE [Klienti] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Klienti] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Klienti] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Klienti] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Klienti] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Klienti] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Klienti] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Klienti] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Klienti] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Klienti] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Klienti] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Klienti] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Klienti] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Klienti] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Klienti] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Klienti] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Klienti] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Klienti] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Klienti] SET  MULTI_USER 
GO
ALTER DATABASE [Klienti] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Klienti] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Klienti] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Klienti] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Klienti] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Klienti]
GO
/****** Object:  Table [dbo].[tblKalendari]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKalendari](
	[IDKalendari] [int] IDENTITY(1,1) NOT NULL,
	[DataOraTerminit] [datetime] NOT NULL,
	[DataOraHapur] [datetime] NOT NULL,
	[Komenti] [nvarchar](max) NULL,
	[IDKlienti] [int] NOT NULL,
	[IDMjeku] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IDKalendari] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblKategoria]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKategoria](
	[IDKategoria] [int] NOT NULL,
	[Kategoria] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDKategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblKlienti]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblKlienti](
	[IDKlienti] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [nvarchar](20) NOT NULL,
	[Mbiemri] [nvarchar](20) NOT NULL,
	[Shfrytezuesi] [nvarchar](20) NOT NULL,
	[Parulla] [nvarchar](20) NOT NULL,
	[Vendi] [nvarchar](20) NOT NULL,
	[Aktiv] [int] NOT NULL CONSTRAINT [DF_tblKlienti_Aktiv]  DEFAULT ((0)),
	[IDRoli] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IDKlienti] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblMesazhet]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMesazhet](
	[IDMesazhet] [int] IDENTITY(1,1) NOT NULL,
	[DataOraMesazhit] [datetime] NOT NULL,
	[Mesazhi] [nvarchar](max) NOT NULL,
	[MesazhiShkruajti] [int] NOT NULL,
	[IDKlienti] [int] NOT NULL,
	[IDMjeku] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IDMesazhet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblMjeku]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMjeku](
	[IDMjeku] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [nvarchar](20) NOT NULL,
	[Mbiemri] [nvarchar](20) NOT NULL,
	[Shfrytezuesi] [nvarchar](20) NOT NULL,
	[Parulla] [nvarchar](20) NOT NULL,
	[Vendi] [nvarchar](20) NOT NULL,
	[Aktiv] [int] NOT NULL,
	[IDRoli] [int] NOT NULL,
	[IDKategoria] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IDMjeku] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRoli]    Script Date: 3/25/2018 11:30:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoli](
	[IDRoli] [int] NOT NULL,
	[Roli] [nvarchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IDRoli] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tblKalendari] ADD  CONSTRAINT [DF_tblKalendari_DataOraHapur]  DEFAULT (getdate()) FOR [DataOraHapur]
GO
ALTER TABLE [dbo].[tblMesazhet] ADD  CONSTRAINT [DF_tblMesazhet_DataOraHapur]  DEFAULT (getdate()) FOR [DataOraMesazhit]
GO
ALTER TABLE [dbo].[tblMjeku] ADD  CONSTRAINT [DF_tblMjeku_Aktiv]  DEFAULT ((0)) FOR [Aktiv]
GO
ALTER TABLE [dbo].[tblKalendari]  WITH CHECK ADD FOREIGN KEY([IDKlienti])
REFERENCES [dbo].[tblKlienti] ([IDKlienti])
GO
ALTER TABLE [dbo].[tblKalendari]  WITH CHECK ADD FOREIGN KEY([IDMjeku])
REFERENCES [dbo].[tblMjeku] ([IDMjeku])
GO
ALTER TABLE [dbo].[tblKlienti]  WITH CHECK ADD FOREIGN KEY([IDRoli])
REFERENCES [dbo].[tblRoli] ([IDRoli])
GO
ALTER TABLE [dbo].[tblMesazhet]  WITH CHECK ADD FOREIGN KEY([IDKlienti])
REFERENCES [dbo].[tblKlienti] ([IDKlienti])
GO
ALTER TABLE [dbo].[tblMesazhet]  WITH CHECK ADD FOREIGN KEY([IDMjeku])
REFERENCES [dbo].[tblMjeku] ([IDMjeku])
GO
ALTER TABLE [dbo].[tblMjeku]  WITH CHECK ADD FOREIGN KEY([IDKategoria])
REFERENCES [dbo].[tblKategoria] ([IDKategoria])
GO
ALTER TABLE [dbo].[tblMjeku]  WITH CHECK ADD FOREIGN KEY([IDRoli])
REFERENCES [dbo].[tblRoli] ([IDRoli])
GO
USE [master]
GO
ALTER DATABASE [Klienti] SET  READ_WRITE 
GO
