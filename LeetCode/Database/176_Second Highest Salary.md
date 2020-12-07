## Description
<pre>
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
</pre>

## SQL query
```mysql
# Write your MySQL query statement below
SELECT IFNULL (
        (SELECT DISTINCT Salary # 不重複
            FROM Employee
            ORDER BY Salary DESC # 以 Salary 排序（大 -> 小）
            LIMIT 1 # 取出 1 筆
            OFFSET 1 ) # 從第 2 筆
    , NULL) AS SecondHighestSalary # 虛擬表
```

## Ref
URL：[IFNULL](https://www.w3schools.com/sql/func_mysql_ifnull.asp)
