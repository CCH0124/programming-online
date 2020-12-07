# Descrption
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
![](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
<pre>
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
</pre>

## Code
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> row =  null;
        for (int i = 1; i <= numRows; i++){
            row = new ArrayList<Integer>();
            for (int j = 0; j < i; j++){
                if(j == 0 || j == i - 1){
                    row.add(1);
                }else{
                    row.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }
            }
            list.add(row);
        }
        return list;
        
    }
}
```