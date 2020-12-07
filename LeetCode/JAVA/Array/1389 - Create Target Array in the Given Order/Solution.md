Given two arrays of integers `nums` and `index`. Your task is to create *target* array under the following rules:

- Initially target array is empty.
- From left to right read nums[i] and index[i], insert at index `index[i]` the value `nums[i]` in target array.
- Repeat the previous step until there are no elements to read in `nums` and `index`.
R
eturn the *target* array.

It is guaranteed that the insertion operations will be valid.

##### Example 1:
```
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
```
##### Example 2:
```
Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
```
##### Example 3:
```
Input: nums = [1], index = [0]
Output: [1]
```

##### Constraints:

- 1 <= nums.length, index.length <= 100
- nums.length == index.length
- 0 <= nums[i] <= 100
- 0 <= index[i] <= i

## Solution
```java
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int [] arr = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            if(index[i] < i) { // 表示會修改到先前 array
                int [] temp = Arrays.copyOfRange(arr, index[i], i); // 將要移動的 array 複製
                arr[index[i]] = nums[i];
                for (int j=1; j<=temp.length; j++){
                    arr[index[i]+j] =  temp[j-1]; // 複寫該插入值 index 後面
                }
            } else {
                arr[index[i]] = nums[i];
            }
        }
        return arr;
    }
}
```

- [更好的邏輯](https://leetcode.com/problems/create-target-array-in-the-given-order/discuss/568684/Java-100-time-and-memory)
