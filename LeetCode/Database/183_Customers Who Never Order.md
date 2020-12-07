## Description
<pre>
Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
</pre>

## SQL query
```mysql
# Write your MySQL query statement below
SELECT C.Name AS Customers
    FROM Customers AS C LEFT JOIN Orders AS O
    ON C.Id = O.CustomerId
    WHERE O.CustomerId IS NULL
```

## LEFT JOIN
即使右表中沒有匹配（Orders），`LEFT JOIN` 關鍵字也會返回左表（Customers）中的所有記錄。
