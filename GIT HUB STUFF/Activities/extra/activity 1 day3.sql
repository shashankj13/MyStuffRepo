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
SELECT * FROM CUSTOMER;
SELECT * FROM salespeople;
SELECT * FROM orders ORDER BY onum DESC;

SELECT COUNT(rating) AS NO_of_ROWS FROM customer  -- q1 

SELECT o.onum,c.cname,s.sname FROM orders o,customer c ,salespeople s WHERE o.cnum=c.cnum AND c.snum=s.snum ORDER BY o.onum DESC ;  --q2

SELECT odate,COUNT(DISTINCT (snum)) FROM orders GROUP BY (odate); --q3

SELECT o.onum,s.sname FROM orders o , salespeople s WHERE s.city = 'LONDON' AND o.snum=s.snum;  --q4

SELECT snum FROM orders GROUP BY snum HAVING COUNT(cnum)>1; --q5

SELECT cname FROM customer WHERE cname LIKE 'C%';  -- q6

SELECT MAX(rating),city FROM customer GROUP BY city;  --q7

SELECT MIN(amt),cnum FROM orders GROUP BY cnum; --q8

SELECT * FROM customer WHERE cname LIKE 'G%' LIMIT 1; --q9

SELECT COUNT(DISTINCT city) FROM customer WHERE city IS NOT NULL; --q10 

SELECT AVG(amt) AS AVERAGE FROM orders; --q11

SELECT cname  FROM customer WHERE city <> 'sanjose' AND rating>200; --q12


SELECT MAX(rating)FROM customer (SELECT rating FROM customer WHERE cnum=(SELECT cnum FROM orders GROUP BY cnum ORDER BY COUNT(cnum) DESC LIMIT 1)); --q13 (doubt)


SELECT * FROM customer WHERE city IS NULL; --q14

SELECT * FROM orders ORDER BY cnum DESC;  --q15

SELECT DISTINCT(sname) FROM salespeople,orders WHERE orders.snum=salespeople.snum; --q16

SELECT sp.sname,sp.snum FROM salespeople sp,customer c WHERE sp.snum=c.snum  GROUP BY snum HAVING COUNT(cnum)>1; --q17

SELECT COUNT(snum) FROM orders GROUP BY snum ORDER BY COUNT(snum) DESC;  --q18

SELECT * FROM customer WHERE 1 <= (SELECT COUNT(city) FROM customer WHERE city='sanjose'); --q19

SELECT SNUM,MAX(amt) FROM orders o GROUP BY snum;  --q20

SELECT * FROM customer WHERE city='sanjose' AND rating>200; --q21

SELECT * FROM orders WHERE snum =(SELECT snum FROM salespeople WHERE sname='motika') ; --q22

SELECT * FROM orders;
SELECT * FROM CUSTOMER;
SELECT * FROM salespeople;


SELECT snum FROM customer GROUP BY snum HAVING COUNT(cnum)>1; --q23

SELECT c.cname,c.city,sp.sname FROM customer c, salespeople sp WHERE c.city=sp.city AND c.snum=sp.snum; --q24

 SELECT  MAX(o.amt),sp.sname FROM orders o,salespeople sp WHERE o.snum=sp.snum AND sname IN('serres','rikklin') GROUP BY sname; --q25
 

SELECT sname FROM salespeople WHERE city IN('barcelona','london'); --q26

 SELECT cname,snum FROM customer GROUP BY snum HAVING COUNT(cnum)=1; --q27
 
 SELECT  DISTINCT(sp.sname),o.amt FROM orders o,salespeople sp WHERE o.snum=sp.snum AND amt>(SELECT AVG(amt) FROM orders) ; --q28
 
 SELECT sname,comm FROM salespeople WHERE city='london'; --q29
  
  
SELECT COMM FROM salespeople INNER JOIN customer ON salespeople.`SNUM`=customer.`SNUM` AND customer.`CITY`='London' --q30

SELECT AVG(COMM) FROM salespeople WHERE CITY = 'London' --q31

SELECT (comm/ (SELECT SUM(comm) FROM salespeople ))AS commision FROM salespeople; --q32

SELECT * FROM salespeople WHERE (comm/ (SELECT SUM(comm) FROM salespeople )) BETWEEN .10 AND .12; --q33(Ask)

SELECT SNAME, CITY FROM salespeople WHERE comm>10 AND CITY = 'London'; --q34 

SELECT * FROM salespeople;   --q35

SELECT DISTINCT s1.sname FROM salespeople AS s1,salespeople AS s2 WHERE s1.city=s2.city AND s1.comm<>s2.comm; --q36

SELECT snum,sname,comm,city FROM salespeople; --q37

 




