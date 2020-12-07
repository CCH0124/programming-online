## Description
<pre>
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.
</pre>

## SQL query
```mysql
# Write your MySQL query statement below
SELECT P.Email AS Email
    FROM Person AS P
    GROUP BY P.Email
    HAVING count(P.Email) > 1 # 紀錄 query 出來筆數
```

## Ref

URL：[GROUP BY](https://www.w3schools.com/sql/sql_groupby.asp)
