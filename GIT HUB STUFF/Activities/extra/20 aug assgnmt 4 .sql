USE DATABASE sales
SELECT * FROM customer
1.
SELECT COUNT(rating) FROM customer   

2.
SELECT orders.onum, salespeople.sname, customer.`cname`
FROM orders, salespeople,customer
WHERE orders.snum = salespeople.`snum`
AND orders.`cnum`= customer.`cNUM`

SELECT onum, cname, sname
FROM  orders
INNER JOIN customer
ON orders.cnum= customer.`cnum`
INNER JOIN salespeople 
ON orders.`SNUM`=salespeople.`snum`

3. 
SELECT COUNT(DISTINCT(snum)) 
FROM orders
GROUP BY(odate) 

4.
SELECT orders.onum , salespeople.sname, salespeople.`city`
FROM  orders, salespeople
WHERE salespeople.city = 'london'
AND orders.snum= salespeople.`snum`

5.
SELECT sname FROM salespeople 
WHERE snum IN(SELECT snum FROM orders GROUP BY(snum) HAVING COUNT(cnum)>1)

6.
SELECT cname FROM customer WHERE cname LIKE 'c%'  

7.
SELECT MAX(rating),city FROM customer GROUP BY city 

8.
SELECT MIN(AMT),cnum FROM orders GROUP BY cnum  

9. 
SELECT cname FROM customer WHERE cname LIKE 'g%' LIMIT 1 

10. 
SELECT COUNT(DISTINCT city) FROM customer 
WHERE city IS NOT NULL ;

11.
SELECT AVG(amt) FROM orders

12. 
SELECT cname FROM customer 
WHERE city NOT LIKE 'sanjose' 
AND rating > 200

13.


14. 
SELECT * FROM customer WHERE city IS NULL 

15.
SELECT * FROM orders
ORDER BY cnum DESC

16.
SELECT DISTINCT (sname) FROM salespeople, orders
WHERE salespeople.`snum`= orders.`SNUM`

17.
SELECT sname, orders.snum 
FROM salespeople 
INNER JOIN orders
ON orders.snum= salespeople.SNUM
GROUP BY snum 
HAVING COUNT(DISTINCT cnum)>1 

18.
SELECT snum ,COUNT(onum) FROM orders 
GROUP BY snum 
ORDER BY COUNT(onum) DESC  

19.
SELECT * FROM customer 
WHERE 1<=(SELECT COUNT(city) FROM customer WHERE city='sanjose' )

20.
SELECT MAX(amt) FROM orders 
GROUP BY snum 

21.
SELECT cname FROM customer 
WHERE city ='sanjose' 
AND rating>200 

22.
SELECT orders.onum FROM orders , salespeople WHERE orders.`SNUM`=salespeople.`snum` AND salespeople.`sname`='Motika'; 

23. 


24.
SELECT c.cname,s.sname,c.city FROM salespeople s ,customer c WHERE s.city=c.city  AND s.snum=c.snum;

25.
SELECT MAX(amt),salespeople.sname FROM orders,salespeople WHERE orders.snum=salespeople.snum GROUP BY 
salespeople.sname HAVING salespeople.sname='SERRES' OR salespeople.sname='RIKKLIN' ;

26. 
SELECT sname FROM salespeople WHERE City IN('BARCELONA','LONDON');

27. 
SELECT s.sname,s.snum FROM salespeople s,customer c WHERE c.snum=c.snum GROUP BY s.snum HAVING COUNT(c.snum)=1;

SELECT snum,COUNT(snum) AS c FROM customer GROUP BY snum HAVING c=1;

28.
SELECT salespeople.sname,orders.amt FROM orders INNER JOIN salespeople ON orders.`SNUM`=salespeople.`snum` 
WHERE orders.amt > (SELECT AVG(orders.amt) FROM orders);

29.
SELECT sname, comm FROM salespeople 
WHERE city = 'london' 

30. 
SELECT comm FROM salespeople
INNER JOIN customer
ON salespeople.snum= customer.`snum`  
WHERE customer.city = 'london' 

SELECT comm FROM salespeople WHERE snum =(SELECT snum FROM customer WHERE city='london');

31.
SELECT AVG(comm) FROM salespeople WHERE city='london';

32.
SELECT sname,comm,
(comm/(SELECT SUM(comm) FROM salespeople)) AS percent 
FROM salespeople
GROUP BY sname;

33. 
SELECT sname,comm  FROM salespeople WHERE 
(comm/(SELECT SUM(comm) FROM salespeople))BETWEEN .10 AND .12 GROUP BY sname ;

34. 
SELECT * FROM salespeople WHERE (comm/(SELECT SUM(comm) FROM salespeople))>.10;

35. 
SELECT comm,COUNT(comm) FROM salespeople GROUP BY comm;

36.
SELECT DISTINCT s1.sname ,s1.comm FROM salespeople AS s1 , salespeople AS s2 WHERE s1.city=s2.city AND s1.comm<>s2.comm;

37.
SELECT snum,sname,comm,city FROM salespeople;



      
