## Description

<pre>
Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
</pre>

## SQL query

> 假設我取 3.50 為例子。3.50 (4.00、3.85、3.65、3.50)，Rank 為 4，所以抓取大於等於自己的值。

```mysql
# Write your MySQL query statement below
SELECT S.Score, COUNT(distinct S1.Score) AS Rank FROM Scores AS S JOIN Scores AS S1 ON S.Score <= S1.Score
GROUP BY S.Id
ORDER BY S.Score DESC;
```
