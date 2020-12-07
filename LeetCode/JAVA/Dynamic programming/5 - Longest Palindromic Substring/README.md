Given a string `s`, return the longest palindromic substring in `s`.

 

##### Example 1:
```
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```
##### Example 2:
```
Input: s = "cbbd"
Output: "bb"
```
##### Example 3:
```
Input: s = "a"
Output: "a"
```
##### Example 4:
```
Input: s = "ac"
Output: "a"
```

##### Constraints:

- `1 <= s.length <= 1000`
- `s` consist of only digits and English letters (lower-case and/or upper-case),

## Code
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return s;   
        }
        int start = 0;
        int end = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        for (int i=0; i<dp.length; i++){
            dp[i][i] = true;
        }
        
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                end = i+1;
            }
        }
        int max = 0;
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i < s.length()-len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    start = i;
                    end = len+i;
                }
            }
        }
        
        return s.substring(start, end+1);
    }

}
```
