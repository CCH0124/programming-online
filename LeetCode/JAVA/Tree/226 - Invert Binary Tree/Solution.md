Invert a binary tree.

Example:

Input:
```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```
Output:
```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

## code
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        // 用 swap 方式，每到一個節點就交換
            TreeNode curr = queue.poll();
            TreeNode tempLeft = curr.left;
            curr.left = curr.right;
            curr.right = tempLeft;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }
}
```
