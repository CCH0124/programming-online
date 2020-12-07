Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:
```
   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> stackNode = new Stack<TreeNode>();
        Stack<String> stackPath = new Stack<String>();
        if(root == null) return list;
        stackNode.push(root);
        stackPath.push("");
        while(!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            String tempPath = stackPath.pop();
        
            if(node.left == null && node.right == null) {
                list.add(0, tempPath + node.val);
            }
            if(node.left != null) {
                stackNode.push(node.left);
                stackPath.push(tempPath + node.val + "->");
            }
            if(node.right != null) {
                stackNode.push(node.right);
                stackPath.push(tempPath + node.val + "->");
            }
        }
        return list;        
        
    }
}
```


```
  10
 /  \
 8   2
/  \ /
3  5 2


stackNode[10]
stackPath[]
list[]
node
tempPath
1.
stackNode[]
stackPath[]
list[]
node = 10
tempPath = ""

stackNode[8, 2]
stackPath[10, 10]
list[]
node = 
tempPath = 
2.
stackNode[8]
stackPath[10]
list[]
node = 2
tempPath = 10

stackNode[8, 2]
stackPath[10, 10->2]
list[]
node = 
tempPath = 
3.
stackNode[8]
stackPath[10]
list[]
node = 2
tempPath = 10->2

stackNode[8]
stackPath[10]
list[]
node = 2
tempPath = 10->2
4.
stackNode[8]
stackPath[10]
list[]
node = 2
tempPath = 10->2->2


stackNode[8]
stackPath[10]
list[10->2->2]
node = 2
tempPath = 
5.
stackNode[]
stackPath[]
list[10->2->2, ]
node = 8
tempPath = 10

stackNode[3,5]
stackPath[10->8, 10->8]
list[10->2->2, ]
node = 8
tempPath = 10
6.
stackNode[3]
stackPath[10->8]
list[10->2->2, ]
node = 5
tempPath = 10->8

stackNode[3]
stackPath[10->8]
list[10->8->5,10->2->2]
node = 5
tempPath = 10->8
7.
stackNode[]
stackPath[]
list[10->8->5,10->2->2]
node = 3
tempPath = 10->8


stackNode[]
stackPath[]
list[10->8->3,10->8->5,10->2->2]
node = 3
tempPath = 10->8
```
