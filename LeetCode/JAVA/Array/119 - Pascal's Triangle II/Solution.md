# Description
Given a non-negative index k where k ≤ 33, return the $k^th$ index row of the Pascal's triangle.

Note that the row index starts from 0.

![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**
<pre>
Input: 3
Output: [1,3,3,1]
</pre>
**Follow up:**

Could you optimize your algorithm to use only O(k) extra space?

## Code
```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++){
            for (int j = list.size() - 2; j >= 0; j--){
                list.set(j + 1, list.get(j) + list.get(j + 1));
            }
            list.add(1);
        }
        return list;
    }
}
/*
rowIndex = 3
list = [1]
i = 1
1 <= 3
j = -1
list [1, 1]

i = 2
j = 2 - 2
list [1, 2, 1]

i = 3
j = 3 - 2
list [1, 2, 3]
j = 0
list [1, 3, 3]

list [1, 3, 3, 1]
*/
```