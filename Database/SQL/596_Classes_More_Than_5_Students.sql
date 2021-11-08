# Write your MySQL query statement below
# Using GROUP BY and HAVING
SELECT class FROM Courses Group by class HAVING COUNT(DISTICNT student) >= 5;

# Using GROUP BY and sub-query
SELECT class FROM
			(SELECT class, COUNT(DISTINCT student) AS num FROM courses GROUP BY class) AS COUNT_TABLE
WHERE num >= 5;