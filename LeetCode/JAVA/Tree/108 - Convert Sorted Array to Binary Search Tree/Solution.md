Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:
<pre>
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
</pre>

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)  return null;
        return helper(nums,0,nums.length - 1);
    }
    public TreeNode helper(int nums [],int left,int right){
        if (left > right)   return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
```
## BST 
1. 若任意節點的左子樹不空，則左子樹上所有節點的值均小於它的根節點的值
2. 若任意節點的右子樹不空，則右子樹上所有節點的值均大於它的根節點的值
3. 任意節點的左、右子樹也分別為二元搜尋樹
4. 沒有鍵值相等的節點

## Ref

[BST](https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst)

[wiki](https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%85%83%E6%90%9C%E5%B0%8B%E6%A8%B9)

[blog](http://emn178.pixnet.net/blog/post/94574434-%E8%B3%87%E6%96%99%E7%B5%90%E6%A7%8B---%E4%BA%8C%E5%85%83%E6%90%9C%E7%B4%A2%E6%A8%B9%28binary-search-tree%29)
