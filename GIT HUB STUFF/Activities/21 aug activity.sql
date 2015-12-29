-- Query 1 --

CREATE VIEW cust_sp AS (SELECT c.cnum , c.cname , c.city AS customer_city , s.snum , s.sname, s.city sp_city FROM customer c  
INNER JOIN salespeople s ON (s.snum=c.snum));

SELECT cust_sp.*,o.* FROM cust_sp INNER JOIN orders o ON o.cnum=cust_sp.cnum;



-- Query 2 --

-- function definition--

DELIMITER $$

CREATE
 
    FUNCTION `res`.`query2`
    (
    sname VARCHAR(50),
    cname VARCHAR(50),
    city VARCHAR(50)
    )
    RETURNS VARCHAR(200) 
   
    BEGIN
    DECLARE Final VARCHAR(200);
	SET final = CONCAT("this salespeople (",sname,") has cust (",cname,")in the city(",city,")");
	RETURN final ;
    END$$

DELIMITER ;

-- query -- 

SELECT query2(s.sname,c.cname,c.city) AS result FROM customer c INNER JOIN salespeople s ON (c.snum=s.snum); 





-- Query 3 -- 

-- function definition--

DELIMITER $$

CREATE
  
    FUNCTION `res`.`query3`(value1 INT )
    RETURNS VARCHAR(300)

    DECLARE rating VARCHAR(300);
    IF value1 > 300
	THEN SET rating = 'excellent';
	
    ELSEIF value1 > 200
	THEN SET rating = 'good';
	
    ELSE 
	SET rating = 'average';

END IF ;

RETURN rating;
    END$$

DELIMITER ;

-- query ---

SELECT query3(rating) FROM customer;




-- Query 4 --


-- function definition --

DELIMITER $$

CREATE
    
    FUNCTION `res`.`query4`(value1 VARCHAR(50) )
    RETURNS VARCHAR(60)
    BEGIN
    DECLARE first_3 VARCHAR(50);
    SET first_3 = SUBSTRING(value1,1,3);
    
RETURN first_3;
    END$$

DELIMITER ;

SELECT query4('shashank');

-- Query 5 -- 

-- procedure definition --
DELIMITER $$

CREATE
    PROCEDURE `res`.`sp1`(value1 VARCHAR(50))
    BEGIN
    SELECT * FROM customer WHERE city = value1;
    END$$

DELIMITER ;

 -- query --
 
CALL sp1('barlin');




-- Query 6 -- 

-- stored procedure definition --
DELIMITER $$

CREATE
  
    PROCEDURE `res`.`sp2`(value1 INT)
    
    BEGIN
    IF value1 != 0  
    
    THEN SELECT * FROM customer WHERE rating=value1;
    
    
    ELSE 
	SELECT * FROM customer;
	
	
	END IF; 

    END$$

DELIMITER ;

-- query--

CALL sp2(541);

SELECT * FROM salespeople;


-- Query 7 --


-- stored procedure definition --

DELIMITER $$
CREATE
    PROCEDURE `res`.`sp3`(value1 VARCHAR(50))
    BEGIN

SELECT (comm*100 / (SELECT SUM(comm) FROM salespeople)) 
AS Comm_Percentage  FROM salespeople WHERE sname = value1;
    
    END$$
DELIMITER ;


-- query--

CALL sp3('peel');




-- Query 12 --

-- function definition

DELIMITER $$
CREATE
        FUNCTION `res`.`query12`(value1 INT)
    RETURNS VARCHAR(300)
     BEGIN
     DECLARE result VARCHAR(300);
     SET result = (SELECT SUM(amt) FROM orders WHERE cnum=value1 GROUP BY cnum);
     
	RETURN result;
    END$$

DELIMITER ;

-- query -- 

SELECT query12(2002);





