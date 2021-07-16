# Write your MySQL query statement below
# GROUP BY and HAVING
SELECT Email FROM Person GROUP BY Email HAVING COUNT(*) > 1;

# GROUP BY and Nested table
SELECT Email FROM
	(SELECT Email, COUNT(*) as No_email FROM Person GROUP BY Email)
	as statistic WHERE No_email > 1;