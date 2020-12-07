Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:
```java
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
```
Example 2:
```java
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
```
## code
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}


/*
[0,1,2,2,3,0,4,2] & val = 2

index = 0

i = 0
0 != 2
index = 0
[0,1,2,2,3,0,4,2]
index = 1

i = 1
1 != 2
index = 1
[0,1,2,2,3,0,4,2]
index = 2

i = 2
2 != 2
index = 2
[0,1,2,2,3,0,4,2]
index = 2

i = 3
2 != 2
index = 2
[0,1,2,2,3,0,4,2]
index = 2

i = 4
3 != 2
index = 2
[0,1,3,2,3,0,4,2]
index = 3

i = 5
0 != 2
index = 3
[0,1,3,0,3,0,4,2]
index = 4

i = 6
4 != 2
index = 4
[0,1,3,0,4,0,4,2]
index = 5

i = 7
2 != 2
[0,1,3,0,4,0,4,2]
index = 5

*/
```
