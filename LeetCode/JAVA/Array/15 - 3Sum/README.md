Given an array `nums` of n integers, are there elements a, b, c in `nums` such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

##### Example 1:
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```
##### Example 2:
```
Input: nums = []
Output: []
```
##### Example 3:
```
Input: nums = [0]
Output: []
```

##### Constraints:

- `0 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

## Code
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList();
        Set<List<Integer>> result = new HashSet<>();
        nums = IntStream.of(nums).sorted().toArray();
        for(int i=0; i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if( sum==0 ){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                } 
                if (sum > 0){
                    end--;  
                } 
                
                if (sum < 0) {
                    start++;
                }

            }
            
        }
    
        return new ArrayList<>(result);
    }
}
```
