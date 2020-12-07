Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
<pre>
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
</pre>
Example 2:
<pre>
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
</pre>

## Code
```java
class Solution {
    public int[] plusOne(int[] digits) {
        
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){ 
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    
    
}

/*
digits = [1, 9, 9]
i = 2
digits[2] < 9
digits[2] = 0
digits = [1, 9, 0]

i = 1
digits[1] < 9
digits[1] = 0
digits = [1, 0, 0]

i = 0
digits[0] < 9
digits[0] = 2 
digits = [2, 0, 0]

*/
```
