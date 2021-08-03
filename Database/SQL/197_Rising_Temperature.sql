# Write your MySQL query statement below
#WHERE
SELECT w2.id FROM Weather w1, Weather w2
    WHERE w2.temperature > w1.temperature AND w2.recordDate = w1.recordDate + interval 1 day;
    
#JOIN, DATEDIFF
SELECT w1.id
FROM weather w1 JOIN weather w2 ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
                                    AND w1.temperature > w2.temperature;