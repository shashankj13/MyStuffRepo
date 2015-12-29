CREATE TABLE resource(id INT PRIMARY KEY , NAME VARCHAR(50) , DOJ DATE , YOE INT , Yash_EmpID VARCHAR(50),location_id INT);

CREATE TABLE location (location_id INT PRIMARY KEY , loaction_name VARCHAR(200));

CREATE TABLE resources_hours(resourcehrs_ID INT , resourceID INT , hours INT , week_endDate DATE );
ALTER TABLE resources_hours ADD PRIMARY KEY(resourcehrs_ID);

CREATE TABLE project (projectid INT PRIMARY KEY , projectname VARCHAR(50) , location_id INT );

INSERT INTO resource VALUES (1,'Deepak Hakare','2014/01/20',1,'1002899',1);
INSERT INTO resource VALUES (2, 'Aadesh jain',       '2012/9/10', 8, '1003927', 1),
 (3, 'Aafaque khan',      '2008/3/28', 8, '1001553', 2),
 (4, 'Aakash jain',       '2015/9/3',  2, '1000193', 3),
 (5, 'Aamer ved',         '2015/3/26', 3, '1003719', 1),
 (6, 'Aarti patankar',    '2014/12/1', 4,       '1003813', 2),
 (7, 'Aashish maheshwari','2014/03/13',8, '1003549', 1), 
 (8, 'Aashutosh soni',  '2014/5/19', 6, '1003054', 2),
 (9, 'Aasish sinha',  '2012/5/25', 7, '1003177', 1);
 
 SELECT * FROM resource;
 
 INSERT INTO location VALUES(1,'Indore'),(2,'Pune'),(3,'Banglore'),(4,'Mumbai');
 
 SELECT * FROM location;
 
 INSERT INTO resources_hours VALUES(1,1,8,'2014/12/26'),(2,2,9,'2014/12/26'),
 (3,3,2,'2014/12/26'),(4,4,3,'2014/12/26'),(5,5,5,'2015/06/26'),
 (6,2,8,'2015/06/26'),(7,1,7,'2015/06/26');
 
 SELECT * FROM resources_hours;
 
 INSERT INTO project VALUES (1,'project1',1) ,  (2,'project2',1) ,
  (3,'project3',3) , (4,'project4',4) ;

SELECT * 
FROM project;

ALTER TABLE resource ADD FOREIGN KEY(location_id) REFERENCES location(location_id);

ALTER TABLE project ADD FOREIGN KEY(location_id) REFERENCES location(location_id);

ALTER TABLE resource ADD FOREIGN KEY(location_id) REFERENCES location(location_id);


SELECT *  FROM resource r  INNER JOIN location l  ON r.location_id = l.location_id WHERE YOE > 2 ; -- q1  

SELECT  * FROM resource WHERE YOE= (SELECT MAX(YOE) FROM resource); --q2


SELECT *  FROM resource r  INNER JOIN location l  ON r.location_id = l.location_id WHERE location_name='Indore_DC' ; -- q3

SELECT * FROM resources_hours rh INNER JOIN resource r ON rh.`resourceID`=r.`id` INNER JOIN   location l ON r.`location_id`=l.`location_id`; --q4


DELETE FROM location WHERE location_name = 'Mumbai'; --q5

SELECT * FROM location l INNER JOIN resource r ON l.`location_id`=r.`location_id` INNER JOIN project p ON r.`location_id`=p.`location_id` 
INNER JOIN resources_hours rh ON r.`id`=rh.`resourceID`;  -- q6

ALTER TABLE project ADD FOREIGN KEY(location_id) REFERENCES location(location_id);
ALTER TABLE project DROP PRIMARY KEY; --q7

ALTER TABLE project ADD PRIMARY KEY(projectid);
ALTER TABLE project DROP FOREIGN KEY project_ibfk_1;
ALTER TABLE project DROP FOREIGN KEY project_ibfk_2;
ALTER TABLE project DROP FOREIGN KEY project_ibfk_3; --q7


UPDATE location SET location_name='Indore_DC' WHERE location_id = 1; --q8

SELECT * FROM location;

ALTER TABLE resources_hours ADD FOREIGN KEY(resourceID) REFERENCES resource(id);


ALTER TABLE resource ADD FOREIGN KEY(location_id) REFERENCES location(location_id) ON DELETE CASCADE;

ALTER TABLE project ADD FOREIGN KEY(location_id) REFERENCES location(location_id) ON DELETE CASCADE;








