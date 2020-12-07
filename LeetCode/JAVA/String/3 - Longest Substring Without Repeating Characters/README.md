Given a string s, find the length of the longest substring without repeating characters.

 

##### Example 1:
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```
##### Example 2:
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
##### Example 3:
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
##### Example 4:
```
Input: s = ""
Output: 0
```

##### Constraints:

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols and spaces.

## Code

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int max = 0;
        int i = 0;
        int j = 1;
        StringBuilder sb = new StringBuilder();
        while (j <= s.length()){
            String subset = s.substring(i,j);
            int deleteIndex = sb.indexOf(subset); // 是否在前面有重複過
            if (deleteIndex != -1){
                sb.delete(0, deleteIndex+1);
            }
            sb.append(subset);
            max = Math.max(max, sb.length());
            i++;
            j++;
        }
        
        return max++;
    }
}
```
