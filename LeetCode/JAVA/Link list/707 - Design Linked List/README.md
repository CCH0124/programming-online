Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

- get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
- addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
- addAtTail(val) : Append a node of value val to the last element of the linked list.
- addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
- deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
### Example:
```java
MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
```
### Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.

## Code
```java
class MyLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    private Node linkList;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        linkList = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size <= index) return -1;
        Node temp = linkList;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = linkList;
        linkList = node;
        size++;
        // Node temp = linkList;
        // linkList = new Node(val);
        // linkList.next = temp;
        // size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (linkList == null) {
            linkList = node;
        } else {
            Node temp = linkList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            Node temp = linkList;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(linkList == null) return;
        if(index > size-1) return;
        if(index == 0) {
            linkList.next = linkList;
            size--;
            return;
        }else{
            Node tmp = linkList;
            for(int i = 1; i < index; i++){
                tmp = tmp.next;
            }
            Node prev = tmp;
            prev.next = tmp.next.next;
            size--;
            return;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```
