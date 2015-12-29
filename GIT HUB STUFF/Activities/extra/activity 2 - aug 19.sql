CREATE DATABASE res
USE res

CREATE TABLE SALESPEOPLE(SNUM INT PRIMARY KEY ,SNAME VARCHAR(200), 
CITY VARCHAR(200),COMM INT);

CREATE TABLE CUSTOMER( CNUM INT PRIMARY KEY, CNAME VARCHAR(200),
CITY VARCHAR(200),SNUM INT,RATING INT);

CREATE TABLE ORDERS(ONUM INT,AMT FLOAT,
SNUM INT,CNUM INT,ODATE DATE);

INSERT INTO SALESPEOPLE VALUES
(1001,'PEEL','LONDON',12),
(1002,'SERRES','SANJOSE',14),
(1003,'AXCELRO','NEW YORK',10),
(1004,'MOTIKA','LONDON',11),
(1005,'FRAN','LONDON',26),
(1007,'RIKKLIN','BARCELONA',21);

SELECT * FROM SALESPEOPLE;

INSERT INTO CUSTOMER VALUES
(2001,'KELVIN','SANJOSE',1007,200),
(2002,'GIOVANNI','ROME',1003,200),
(2003,'LIU','SANJOSE',1002,200),
(2004,'GRASS','BARLIN',1002,300),
(2006,'CLEMENS','LONDON',1001,100),
(2007,'PEREIRA','ROME',1004,100),
(2008,'CISNEROS','SANJOSE',1007,300);

SELECT * FROM CUSTOMER;


INSERT INTO ORDERS VALUES
(3001,18.69,1007,2008,'2014/10/03'),
(3003,890.00,1001,2002,'2014/10/03'),
(3002,1900.10,1004,2007,'2014/10/03'),
(3005,5160.45,1002,2003,'2014/10/03'),
(3006,1098.16,1007,2008,'2014/10/03'),
(3009,1713.23,1003,2002,'2014/10/04'),
(3007,75.75,1003,2002,'2014/10/04'),
(3008,4723,1001,2006,'2014/10/04'),
(3010,1309.95,1002,2004,'2014/10/05'),
(3011,9891.8,1001,2006,'2014/10/05');

SELECT * FROM orders;


DESC SALESPEOPLE;  --q1

SELECT * FROM customer WHERE rating=100;  --q2

SELECT * FROM CUSTOMER WHERE city IS NULL;  --q3 

SELECT CNAME FROM CUSTOMER WHERE CNUM IN (SELECT CNUM FROM orders WHERE odate='2014/10/03');  --q4

SELECT snum , sname , comm ,city FROM SALESPEOPLE;  --q5

SELECT * FROM orders ORDER BY cnum DESC; --q6

 SELECT SNUM,COUNT(SNUM) FROM orders GROUP BY snum ORDER BY SNUM DESC LIMIT 1;  --q7
 SELECT SNUM,COUNT(SNUM) FROM orders GROUP BY snum ORDER BY SNUM LIMIT 1;
 
 
SELECT SUM(AMT) AS total_amount FROM orders WHERE cnum=2002; --q8

SELECT onum AS oldest_order FROM orders WHERE CNUM = 2002 AND odate= (SELECT MIN(odate) FROM orders);  --q9

UPDATE orders SET cnum = 2007 WHERE cnum=2008; -- q10 
