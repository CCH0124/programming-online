## Description
<pre>
There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+
Note:
The students should not be counted duplicate in each course.
</pre>

## SQL query
```mysql
# Write your MySQL query statement below
SELECT C.class
    FROM courses AS C
    GROUP BY C.class # 把有的課程條列（不重複）
    HAVING COUNT(DISTINCT C.student) >= 5
```
