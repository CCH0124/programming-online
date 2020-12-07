# Description
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

- The number of elements initialized in nums1 and nums2 are m and n respectively.
- You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:
<pre>
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
</pre>
## code
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPoint = m - 1;
        int nPoint = n - 1;
        int len = m + n - 1;
        while(mPoint >= 0 && nPoint >= 0){
            if (nums1[mPoint] > nums2[nPoint]) {
                nums1[len--] = nums1[mPoint--];
            }else{
                nums1[len--] = nums2[nPoint--];
            }
        }
        /*
        nums1 = [0] m = 0
        nums2 = [1] n = 1
        */
        while (nPoint >= 0) {
            nums1[len--] = nums2[nPoint--];
        }
    }
}
/*
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

mPoint = 2
nums1 = [1,2,3]
nPoint = 2
nums2 = [2,5,6]
3 > 6
[1,2,3,0,0,6]

mPoint = 2
nums1 = [1,2,3]
nPoint = 1
nums2 = [2,5]
3 > 5
[1,2,3,0,5,6]

mPoint = 2
nums1 = [1,2,3]
nPoint = 0
nums2 = [2]
3 > 2
[1,2,3,3,5,6]

mPoint = 1
nums1 = [1,2]
nPoint = 0
nums2 = [2]
2 > 2
[1,2,2,3,5,6]

*/
```
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int index = 0;
        for(int i=m; i<m+n; i++)
            nums1[i] = nums2[index++];
        Arrays.sort(nums1);
    }
}
```

