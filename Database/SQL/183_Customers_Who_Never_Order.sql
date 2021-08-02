# Write your MySQL query statement below
#NOT IN
SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN(SELECT CustomerId FROM Orders);

#LEFT JOIN
SELECT Name AS CUstomers
FROM Customers C LEFT JOIN Orders O
ON C.Id = O.CustomerId
WHERE O.CustomerId IS NULL