create database onlineSurvey
go
use onlineSurvey
go
create table manager(
	m_id varchar(10) primary key,
	m_password varchar(20),
)
go
create table ordinaryUser(
	ou_photo varchar(300),
	ou_name varchar(20) primary key,
	ou_phone varchar(20) unique,
	ou_email varchar(30) unique,
	ou_password varchar(20),
	ou_sex varchar(20),
	ou_dateOfBirth varchar(50),
	ou_hobby varchar(50),
)
go
create table company(
	companyName varchar(50) primary key,
	companyType varchar(30),
	companyIndustry varchar(30),
	companyScale varchar(10),
	companyIntroduction varchar(1000),
)
go
create table companyUser(
	cu_photo varchar(300),
	cu_name varchar(20) primary key,
	cu_phone varchar(20) unique,
	cu_email varchar(30) unique,
	cu_password varchar(20),
	cu_sex varchar(20),
	cu_dateOfBirth varchar(50),
	cu_hobby varchar(50),
	companyName varchar(50) foreign key references company(companyName),
)
go
create table survey(
	s_id int Identity(1,1) primary key,
	s_name varchar(100),
	companyName varchar(50) foreign key references company(companyName),
	cu_name varchar(20) foreign key references companyUser(cu_name),
	s_keyWord varchar(10),
	s_finish int,
	s_isRelease varchar(20),
	s_dateOfRelease date,
)
go
create table question(
	s_id int foreign key references survey(s_id),
	q_id int Identity(1,1),
	primary key(s_id,q_id),
	q_content varchar(100),
	Aoption varchar(100),
	Boption varchar(100),
	Coption varchar(100),
	Doption varchar(100),
	Eoption varchar(100),
	Foption varchar(100),
	q_type varchar(20),
	q_size int
)
go
create table user_answer(
	s_id int foreign key references survey(s_id) ,
	q_id int,
	answer varchar(100),
	ou_name varchar(20) foreign key references ordinaryUser(ou_name),
	primary key(s_id,q_id,ou_name)	
)
go
insert into company values('QingDao University','college','Education','Large','It is a famous university')
insert into manager values('A01','123')
