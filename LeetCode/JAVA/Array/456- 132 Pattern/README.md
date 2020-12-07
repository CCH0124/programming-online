Given an array of `n` integers nums, a 132 pattern is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The `O(n^2)` is trivial, could you come up with the `O(n logn)` or the `O(n)` solution?

 

##### Example 1:
```
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
```
##### Example 2:
```
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
```
##### Example 3:
```
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
```

##### Constraints:

- `n == nums.length`
- `1 <= n <= 104`
- `-109 <= nums[i] <= 109`

## Code
利用 `Stack` 方式先存放最大值，當中再執行 `pop` 時，通常就是取 `j`，`j` 用 `k` 來做儲存並尋找 `i` 如果有找到就返回。Stack 中的值會存放最大值，從 `Stack` 替換的值是次大的值。
```java
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int k = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for( int i = nums.length-1; i >= 0; i--){
            if( nums[i] < k ) {
                return true;
            } else {
                while( !stack.isEmpty() && nums[i] > stack.peek()) {
                    k = stack.peek();
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
```
