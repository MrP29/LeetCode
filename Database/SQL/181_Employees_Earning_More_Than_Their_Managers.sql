# Write your MySQL query statement below
SELECT E.Name AS Employee
FROM Employee AS E, Employee AS S
WHERE E.Salary > S.Salary AND E.ManagerId = S.Id;

SELECT E.Name AS Employee
FROM Employee AS E JOIN Employee AS S
ON E.ManagerId = S.Id AND E.Salary > S.Salary;