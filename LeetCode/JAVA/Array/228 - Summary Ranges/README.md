You are given a sorted unique integer array `nums`.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.

Each range `[a,b]` in the list should be output as:

- `"a->b"` if `a != b`
- `"a"` if `a == b`

##### Example 1:
```
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
```
##### Example 2:
```
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
```
##### Example 3:
```
Input: nums = []
Output: []
```
##### Example 4:
```
Input: nums = [-1]
Output: ["-1"]
```
##### Example 5:
```
Input: nums = [0]
Output: ["0"]
``` 

##### Constraints:

- `0 <= nums.length <= 20`
- `-231 <= nums[i] <= 231 - 1`
- All the values of nums are unique.
## Code
```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length <= 0) return list;
        int i = 0; // 用來儲存開始位置
        int j = 1; // 用來移動，並計算當前和前一個數值的 Index 值差
        while(j <= nums.length-1 && i < j){
            int end = nums[j];
            int start =  nums[j-1];
            
            if (Math.abs((end - start)) != 1){
                if ( i == (j-1)){
                    list.add(String.valueOf(start));
                    i++;
                } else {
                    list.add(new String(nums[i]+"->"+nums[j-1]));
                    i = j; // 表示說原先 i 當前的範圍已經搜尋完，因此跳到未計算過的 Index
                }
            }
            j++;
        }
        // 最後情況，i 可能是指向最後一個 Index 表示說 j 也無法前進
        if (i == (nums.length-1)){
            list.add(String.valueOf(nums[i]));
        } else {
            list.add(new String(nums[i]+"->"+nums[j-1]));
        }
        return list;
    }
}
```
