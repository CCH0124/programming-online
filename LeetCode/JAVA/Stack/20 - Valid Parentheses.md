Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

### Example 1:

Input: "()"
Output: true
### Example 2:

Input: "()[]{}"
Output: true
### Example 3:

Input: "(]"
Output: false
### Example 4:

Input: "([)]"
Output: false
### Example 5:

Input: "{[]}"
Output: true

## code
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character sym : s.toCharArray()) {
            if (sym == '(') {
                stack.push(')');
            } else if (sym == '[') {
                stack.push(']');
            } else if (sym == '{') {
                stack.push('}');
            } else {
                if ( stack.isEmpty() || stack.pop() != sym ){ // stack.isEmpty() 是防止因為 ]、) 符號導致 stack 無值
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```
