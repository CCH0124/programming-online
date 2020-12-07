[Tree : Top View](https://www.hackerrank.com/challenges/tree-top-view/problem)

```java
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    /* 
    
    class Node 
        int data;
        Node left;
        Node right;
	*/
    static class MapNode{
        Node node;
        int level;
        public MapNode(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
	public static void topView(Node root) {
        Queue<MapNode> queue = new LinkedList<MapNode>();
       
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    
        queue.add(new MapNode(root, 0));
        
        while(!queue.isEmpty()){
            MapNode r = queue.poll();

            if(!map.containsKey(r.level)){
                map.put(r.level, r.node.data);
            }
            
            if(r.node.left != null){
                queue.add(new MapNode(r.node.left, r.level - 1));
            }
            if(r.node.right != null){
                queue.add(new MapNode(r.node.right, r.level + 1));
            }
        }
    
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
      
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
```