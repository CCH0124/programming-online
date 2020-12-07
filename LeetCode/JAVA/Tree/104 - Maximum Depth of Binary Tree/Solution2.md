以一行一行方式做掃描，一行表示一個深度。

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depath = 0;
        int queueSize = 0;
        TreeNode node = root;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        while(!que.isEmpty()) {
            queueSize = que.size();
            for (int i = 0; i < queueSize; i++) {
                node = que.poll();
                if (node.right != null){
                    que.offer(node.right);
                }
                if (node.left != null){
                    que.offer(node.left);
                }
            }
            depath++;
        }
        
        
        return depath;
    }
}
```

## offer vd add
一些 queue 有大小限制，因此如果想在一個滿的隊列中加入一個新項，多出的項就會被拒絕。這時 offer 方法就可以起作用了。它不是對調用 `add()` 方法拋出一個 `nchecked` 異常，而只是得到由 `offer()` 返回的 false。
