## Description
<pre>
Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
</pre>

## SQL query
```mysql
# Write your MySQL query statement below
SELECT DISTINCT(L.Num) AS ConsecutiveNums FROM Logs AS L
  JOIN Logs L2 ON L.id=(L2.id+1)
  JOIN Logs L3 ON L.id=(L3.id+2)
  WHERE L.num=L2.num and L.num=L3.num;
```
