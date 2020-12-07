Given an integer, write a function to determine if it is a power of two.

Example 1:
```
Input: 1
Output: true 
Explanation: 2^0 = 1
```
Example 2:
```
Input: 16
Output: true
Explanation: 2^4 = 16
```
Example 3:
```
Input: 218
Output: false
```

## code

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
       if (n == 0 || n < 0) return false; 
          
        while (n != 1) { 
            if (n % 2 != 0) return false; 
            n = n / 2; 
        } 
        
        return true; 
    }
}
```
