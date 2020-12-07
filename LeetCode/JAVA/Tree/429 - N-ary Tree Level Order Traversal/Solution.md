Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a `3-ary` tree:

![](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

We should return its level order traversal:
```
[
     [1],
     [3,2,4],
     [5,6]
]
``` 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

## code
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> nodeList;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) return list;
        while(!queue.isEmpty()){
            nodeList = new ArrayList<>();
            Node node = null;
            int size = queue.size();
            for (int i=0; i<size; i++){
                node = queue.poll();
                nodeList.add(node.val);
                // 跌帶每個節點
                for(Node n : node.children) {
                    queue.offer(n);
                }
            }
            
            list.add(nodeList);
        }
        return list;
    }
}
```
