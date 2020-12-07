[題目](https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem)


```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode insertObject = new DoublyLinkedListNode(data);
        DoublyLinkedListNode curr = head;
        while(curr != null){
            if(curr.data >= data){
                // 1 <-> 2 <-> 4 <-> null
                insertObject.next = curr; // 1 <-> 2 3 -> 4 <-> null
                insertObject.prev = curr.prev; // 1 <-> 2 <- 3 -> 4 <-> null
                curr.prev = insertObject; // 1 <-> 2 <- 3 <-> 4 <-> null
                if (insertObject.prev == null){
                    // 如果是插入在開頭
                    return insertObject;
                } else {
                    insertObject.prev.next = insertObject; // // 1 <-> 2 <-> 3 <-> 4 <-> null
                    return head;
                }
            }
            // 插在最後
            if (curr.next == null){
                insertObject.prev = curr;
                insertObject.next = null;
                curr.next = insertObject;
                break;
            }
            curr = curr.next;
        }
        
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);
```