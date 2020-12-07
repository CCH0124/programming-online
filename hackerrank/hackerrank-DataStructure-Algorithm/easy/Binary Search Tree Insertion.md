[題目](https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem)


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
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else if (data < root.data){
            root.left =  insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
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
      	preOrder(root);
    }	
}
```

方法二

```java
public static Node insert(Node root,int data) {
        Node node = new Node(data);
        if (root == null) {
            return node;
        }
        Node r = root;
        Node lParant = null;
        Node rParant = null;
        while(r != null){
            if(data > r.data){
                if(r.right == null){
                    rParant = r; // 儲存找到的點
                }
                r = r.right; // 跳出迴圈
            } else if(data < r.data) {
                if(r.left == null){ 
                    lParant = r;
                }
                r = r.left;
            }
        }

        if(lParant != null){ 
            lParant.left = node;
        }
        if(rParant != null) {
            rParant.right = node;
        }
        return root;
    }
```


使用 queue

```java
public static Node insert(Node root,int data) {
        Node node = new Node(data);
        if (root == null) {
            return node;
        }
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        Node getNode = null;
        Node lParant = null;
        Node rParant = null;
        while(!queue.isEmpty()){
            getNode = queue.remove();
            if (data < getNode.data){
                if (getNode.left != null){
                    queue.add(getNode.left);
                } else {
                    lParant = getNode;
                }
            }
            if (data > getNode.data){
                if (getNode.right != null){
                    queue.add(getNode.right);
                } else {
                    rParant = getNode;
                }
            }
        }


        if(lParant != null){ 
            lParant.left = node;
        }
        if(rParant != null) {
            rParant.right = node;
        }
        return root;
    }
```