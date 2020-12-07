Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

### Example 1:

Input: S = "ab#c", T = "ad#c"

Output: true

Explanation: Both S and T become "ac".
### Example 2:

Input: S = "ab##", T = "c#d#"

Output: true

Explanation: Both S and T become "".
### Example 3:

Input: S = "a##c", T = "#a#c"

Output: true

Explanation: Both S and T become "c".
### Example 4:

Input: S = "a#c", T = "b"

Output: false

Explanation: S becomes "c" while T becomes "b".
### Note:

1 <= S.length <= 200

1 <= T.length <= 200

S and T only contain lowercase letters and '#' characters.
### Follow up:

Can you solve it in O(N) time and O(1) space?

## Code
```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = helper(S);
        Stack stack2 = helper(T);
        if (stack1.size() != stack2.size()) return false;
        while (!stack1.empty() && !stack2.empty()){
            char a = (char)stack1.pop();
            char b = (char)stack2.pop();
            if (a != b) {
                return false;
            }
        }
        return true;
    }
    private Stack helper(String s) {
        Stack<Character> stack = new Stack<>();
        char [] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    continue;
                } else {
                    stack.pop();
                }
            }
        }
        return stack;
    }
}
```
|Runtime|Memory|
|---|---|
|2 ms|36.6 MB|

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
       return helper(S).equals(helper(T));
    }
    private String helper(String s) {
        Stack<Character> stack = new Stack<>();
        char [] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    continue;
                } else {
                    stack.pop();
                }
            }
        }
        return String.valueOf(stack);
    }
}
```
|Runtime|Memory|
|---|---|
|2 ms|36.8 MB|
