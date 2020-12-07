Remove all elements from a linked list of integers that have value val.

Example:
<pre>
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
</pre>
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head.val == val ? head.next : head;
    }
}
```
