A binary tree is univalued if every node in the tree has the same value.

Return `true` if and only if the given tree is univalued.


##### Example 1:
![](https://assets.leetcode.com/uploads/2018/12/28/unival_bst_1.png)

```
Input: [1,1,1,1,1,null,1]
Output: true
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2018/12/28/unival_bst_2.png)

```
Input: [2,2,2,5,2]
Output: false
```

## Code
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int x = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val != x) {
                return false;
            }
            if(node.left !=null){
                stack.push(node.left);
            }
            if(node.right !=null){
                stack.push(node.right);
            }
        }
        return true;
    }
}
```
