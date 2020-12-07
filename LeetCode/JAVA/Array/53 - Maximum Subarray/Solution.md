Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
<pre>
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:
</pre>

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
## Code
```java
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length - 1);
    }
    
    public int maxSubArraySum(int nums[], int left, int right){
        if(left == right){
            return nums[left];
        }
        int mid =  (left + right) / 2;
        
        int leftMaxSubArraySum = maxSubArraySum(nums, left, mid);
        int rightMaxSubArraySum = maxSubArraySum(nums, mid + 1, right);
        
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = mid + 1; i <= right; i++){
            sum += nums[i];
            if (sum > rightSum ){
                rightSum = sum; 
            }
        }
        
        sum = 0;
        
        for (int i = mid; i >= left; i--){
            sum += nums[i];
            if (sum > leftSum ){
                leftSum = sum; 
            }
        }
        
        int result = Math.max(leftMaxSubArraySum, rightMaxSubArraySum);
        
        return Math.max(result, leftSum + rightSum);
    }
    
    
    
}
// https://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
```
