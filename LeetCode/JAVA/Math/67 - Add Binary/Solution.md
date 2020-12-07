Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters `1` or `0`.

##### Example 1:
```
Input: a = "11", b = "1"
Output: "100"
```
##### Example 2:
```
Input: a = "1010", b = "1011"
Output: "10101"
```

##### Constraints:

- Each string consists only of `'0'` or `'1'` characters.
- `1 <= a.length, b.length <= 10^4`
- Each string is either `"0"` or doesn't contain any leading zero.

## Code
```java
class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int carr = 0;
        StringBuilder binaryResult = new StringBuilder();
        while( aLen > 0 || bLen > 0){
            int x = 0;
            int y = 0;
            int r = 0;
            
            if (aLen > 0){
                x = Integer.parseInt(a.substring(aLen-1, aLen));
            }
            if (bLen > 0){
                y = Integer.parseInt(b.substring(bLen-1, bLen));    
            }
            r = (x+y)%2;
            
            if (carr == 1) {
                r = (r+carr)%2;
            }
            carr = (x+y+carr)/2;
            binaryResult.insert(0, r);
            aLen--;
            bLen--;
        }
        if (carr == 1){
            binaryResult.insert(0, carr);
        }
        return binaryResult.toString();
    }
}
```
