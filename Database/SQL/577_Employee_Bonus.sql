# Write your MySQL query statement below
# OUTER JOIN and WHERE
SELECT name, bonus
FROM Employee E LEFT OUTER JOIN Bonus B
ON E.empId = B.empId
WHERE bonus < 1000 OR bonus IS NULL;