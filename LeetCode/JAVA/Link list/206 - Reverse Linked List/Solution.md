Reverse a singly linked list.

Example:
<pre>
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
</pre>
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
## code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null; // 先前
        ListNode curr = head; // 當前
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```
