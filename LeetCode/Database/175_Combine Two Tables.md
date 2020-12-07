## Description
<pre>
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
</pre>
為報表編寫一個SQL查詢，該報表為Person表中的每個人提供以下信息，而不管這些人是否有地址：

`FirstName, LastName, City, State`

## SQL query
LEFT JOIN 關鍵字會從左表（Person）那裡返回所有的行，即使在右表（Address）中沒有匹配的行。
```mysql
# Write your MySQL query statement below
SELECT P.FirstName, P.LastName, A.City, A.State from Person AS P LEFT JOIN Address AS A on P.PersonId = A.PersonId;
```
