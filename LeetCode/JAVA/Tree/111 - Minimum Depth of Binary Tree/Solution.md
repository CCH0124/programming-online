Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree `[3,9,20,null,null,15,7]`,
```
    3
   / \
  9  20
    /  \
   15   7
```
return its minimum depth = 2.

## Solution
以層為想法。

```
    3  ------> 第一層
   / \
  9  20 -----> 第二層
    /  \
   15   7 ---> 第三層
```

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int level = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node;
            size = queue.size();
            for (int i=0; i<size; i++){
                node = queue.poll();
                if (node.left == null && node.right == null){
                    return level;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
```
