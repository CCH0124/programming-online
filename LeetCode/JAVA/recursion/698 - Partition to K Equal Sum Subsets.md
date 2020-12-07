Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

##### Example 1:
```
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

##### Note:

- `1 <= k <= len(nums) <= 16`.
- `0 < nums[i] < 10000`.


## Code
```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        // int max = Arrays.stream(nums).max().getAsInt();
        int max = nums[nums.length - 1];
        int avg = sum / k;
        if (sum % k != 0 || max > avg){
            return false;
        }
        int end = nums.length - 1;
        while (nums[end] == avg && end >= 0){
            end--;
            k--;
        }
        return partition(new int[k], nums, end, avg);
    }
    
    public boolean partition(int [] subset, int[] nums, int index, int target){
        if (index < 0){
            return true;
        }
        int init = nums[index--];
        for(int i=0; i<subset.length; i++){
            if (init + subset[i] <= target){
                subset[i] += init;
                if (partition(subset, nums, index, target)){
                    return true;
                }
                
                subset[i] -= init;
            }
        }
        return false;
    }
}
```
