## Description
<pre>
The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
</pre>

## SQL query
```mysql
# Write your MySQL query statement below# Write your MySQL query statement below
SELECT A.Name AS Employee
FROM Employee as A
INNER JOIN Employee as B
ON A.ManagerId = B.id AND A.Salary > B.Salary;
```

INNER JOIN：返回兩個表中具有匹配值的記錄

![](https://i.imgur.com/q27w2oz.png)
