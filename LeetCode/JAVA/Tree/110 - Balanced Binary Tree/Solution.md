## Description
<pre>
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
</pre>

## Solution
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
    public boolean isBalanced(TreeNode root) {
        deepPath(root);
        return is(flag);
       
        
        
    }
    private Boolean is(int flag){
        return !(flag == -1);
    }
    private int flag = 0;
    private int deepPath(TreeNode node){
        
        if(node == null) return 0;
        int left = deepPath(node.left);
        int right = deepPath(node.right);
        if (Math.abs(left - right) > 1)
            return flag = -1;
        return 1 + Math.max(left, right);
    }
}
```
## Ref
[wiki](https://zh.wikipedia.org/wiki/%E5%B9%B3%E8%A1%A1%E6%A0%91)
