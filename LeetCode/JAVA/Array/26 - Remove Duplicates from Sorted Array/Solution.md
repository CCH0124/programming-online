Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
<pre>
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
</pre>
Example 2:
<pre>
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
</pre>
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

<pre>
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
</pre>
## code
1.
```java
class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>(); // 排序
        for(int n : nums)
            set.add(n); // 放入元素
        Iterator it = set.iterator();
        int i=0;
        // 跌代並覆蓋原陣列
        while(it.hasNext() || i < set.size()){
                nums[i++] = (Integer)it.next();
            
        }
        return set.size();
    }
}
```
2.
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            System.out.println(nums[i] + " " +nums[index]);
            if (nums[i] != nums[index]){
                 nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}

/*
[0, 0, 1, 1, 2, 2, 3, 4]
index = 0
i = 1
0 != 0
index = 0
i = 2
1 != 0
index = 1
[0, 1, 1, 1, 2, 2, 3, 4]
i = 3
1 != 1
index = 1
i = 4
2 != 1
index = 2
[0, 1, 2, 1, 2, 2, 3, 4]
i = 5
2 != 2
index = 2
i = 6
3 != 2
index = 3
[0, 1, 2, 3, 2, 2, 3, 4]
i = 7
4 != 3
index = 4
[0, 1, 2, 3, 4, 2, 3, 4]
return index + 1 共 5 個元素 
*/
```
