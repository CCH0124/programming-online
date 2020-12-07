<pre>
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
<code>
Input: [1,3,5,6], 5
Output: 2
</code>
Example 2:
<code>
Input: [1,3,5,6], 2
Output: 1
</code>
Example 3:
<code>
Input: [1,3,5,6], 7
Output: 4
</code>
Example 4:
<code>
Input: [1,3,5,6], 0
Output: 0
</code>
</pre>

## code
1.
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while(low <= height){
            int mid = mid(low, height);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                height = mid - 1;
            }
        }
        return low;
    }
    private int mid(int low, int height){
        return (low + height) / 2;
    }
    
}

/*
nums = [1,3,5,6], 5
low = 0
height = 3

low <= height
mid = 1
nums[mid] < 5
low = 2

low <= height
mid = 2
nums[mid] == 5
return 2

*/
```
2.
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if(result < 0)
            return (Math.abs(result) - 1); // 這是推倒出來，針對 target 搜尋不到時的位置。
        else
            return result;

    }
}

```
