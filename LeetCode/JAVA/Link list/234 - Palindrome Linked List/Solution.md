Given a singly linked list, determine if it is a palindrome.

Example 1:
<pre>
Input: 1->2
Output: false
</pre>
Example 2:
<pre>
Input: 1->2->2->1
Output: true
</pre>
Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        // 找中間值
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 中間值厚德串列反轉
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 比較
        fast = head;
        while (pre != null) {
            if (fast.val != pre.val) return false;
            fast = fast.next;
            pre = pre.next;
        }
        return true;
    }
    
}
```
