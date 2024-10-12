  create database patient_management ;
  USE patient_management;
  CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    date VARCHAR(10),
    name VARCHAR(50),patients
    height DOUBLE,
    weight DOUBLE,
    blood_pressure_sys DOUBLE,
    blood_pressure_dias DOUBLE,
    sugar_fasting DOUBLE,
    sugar_post_meal DOUBLE,
    red_cell_count FLOAT,
    white_cell_count FLOAT,
    haemoglobin FLOAT,
    pH FLOAT,
    glucose FLOAT,
    protein FLOAT,
    bilirubin FLOAT,
    blood FLOAT,
    leukocytes FLOAT,
    BMI FLOAT,
    ht_wt_check VARCHAR(30),
    BP_check VARCHAR(30),
    sugar_check VARCHAR(30),
    CBC_check VARCHAR(30),
    urine_check VARCHAR(30),
    mental_health VARCHAR(150)
);
use biswa;
create table  private (
rollno INT PRIMARY KEY ,
name VARCHAR(50)
);
insert into private 
(rollno ,name )
values 
(12,"adam"),
(123,"smith");
SELECT
* FROM private ;

CREATE TABLE TEMPQ(
ID INT UNIQUE 
);
INSERT INTO TEMPQ VALUES (101);
INSERT INTO TEMPQ VALUES (102);
INSERT INTO TEMPQ VALUES (103);
INSERT INTO TEMPQ VALUES (104);
INSERT INTO TEMPQ VALUES (105);
INSERT INTO TEMPQ VALUES (106);
INSERT INTO TEMPQ VALUES (107);
INSERT INTO TEMPQ VALUES (108);
INSERT INTO TEMPQ VALUES (109);
INSERT INTO TEMPQ VALUES (101);
select * FROM TEMPQ ;
CREATE TABLE TEMP67(
 AGE INT  ,
NAME VARCHAR(50),
ID INT ,
 CITY VARCHAR(780),
PRIMARY KEY (ID)
);

SELECT * FROM TABLE67 ;
create table TABLE999(
 ID int NOT NULL ,
SALARY double DEFAULT 2222.02
) ;
INSERT INTO TEMP999(ID) VALUES (1,2222.02);
INSERT INTO TEMP999(ID) VALUES (101);
select *  FROM TABLE999 ;
CREATE TABLE STUDENT (
ROLLNO  INT PRIMARY KEY ,
MARKS INT  NOT NULL,
GRADE varchar(78),
CITY varchar(87)

);
insert INTO STUDENT (ROLLNO , MARKS , GRADE , CITY ) VALUES (101,1010,"A","MUMBAI ");
insert INTO STUDENT (ROLLNO , MARKS , GRADE , CITY ) VALUES (103,12,"A","DELHI ");
insert INTO STUDENT (ROLLNO , MARKS , GRADE , CITY ) VALUES (102,21,"A","KOLKATA ");
insert INTO STUDENT (ROLLNO , MARKS , GRADE , CITY ) VALUES (104,1091,"A","DELHI ");
insert INTO STUDENT (ROLLNO , MARKS , GRADE , CITY ) VALUES (105,10,"A","PUNE  ");


SELECT * 
FROM STUDENT 
WHERE MARKS  > 765 ; 
select * FROM STUDENT ORDER BY MARKS ASC ;

select *FROM STUDENT WHERE CITY  NOT IN("CUTTACK");

CREATE DATABASE mydatabase ;
use mydatabase;
create table emp(
id int PRIMARY KEY ,
NAME varchar(255),
JOB varchar(200),
salary double 
);
insert into
emp(id,NAME ,JOB , salary) values ( 1211, "biswajit polai ", " data analyst ", 23113.45);
insert into
emp(id,NAME ,JOB , salary) values ( 1217, "biswajit das ", "  SDE ", 90113.45);
insert into
emp(id,NAME ,JOB , salary) values ( 1215, "biswajit polai ", " SDE II ", 99113.45);
SELECT * FROM emp;