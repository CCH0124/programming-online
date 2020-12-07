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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.right);
        q.add(root.left);
        while(!q.isEmpty()){
            TreeNode q_r = q.poll();
            TreeNode q_l = q.poll();
            if (q_r == null && q_l == null) continue; // 節點為空
            if (q_r == null || q_l == null) return false; // 節點一邊為空
            if (q_r.val != q_l.val) return false; // 比較值
            q.add(q_r.left);
            q.add(q_l.right);
            q.add(q_r.right);
            q.add(q_l.left);
        }
        return true;
    }
}
/**
[2,2]
[]
[3,3,4,4]

[3,3] // 比較
[4,4] 

[4,4] //比較
**/
```
