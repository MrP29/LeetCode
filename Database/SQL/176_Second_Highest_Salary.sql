#Write your MySQL query statement below
#Aggregate Function MAX
SELECT MAX(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary)
                FROM Employee);
                    
#LIMIT and OFFSET
SELECT (SELECT DISTINCT Salary
        FROM Employee ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary;

#IFNULL, LIMIT and OFFSET
SELECT IFNULL(
    (SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1), NULL) AS SecondHighestSalary;

#NOT IN and Aggregate Function MAX
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee);