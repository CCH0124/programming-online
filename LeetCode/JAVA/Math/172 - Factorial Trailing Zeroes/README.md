Given an integer n, return the number of trailing zeroes in n!.

##### Example 1:
```
Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
```
##### Example 2:
```
Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
```

**Note**: Your solution should be in logarithmic time complexity.


## Code
每乘一次 5 就會有一個零。

```java
class Solution {
    public int trailingZeroes(int n) {
        int count =0;
        Long five_powe = 5L;
        while(n >= five_powe) {
            count += n / five_powe;
            five_powe *= 5;
        }
        return count;
    }
}
```

```java
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        if (n < 5){
            return 0;
        } 
        while(n >= 5 ) {
            count += n/5;
            n = n/5;
        }
        return count;
    }
}
```
