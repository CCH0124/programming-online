Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
<pre>
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;

        if(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                result = l1;
                result.next = mergeTwoLists(l1.next, l2);
            } else {
                result = l2;
                result.next = mergeTwoLists(l1, l2.next);
            }
        }
        if (l2 == null){
            result = l1;
        }
        if(l1 == null){
            result = l2;
        }
        return result;
    } 
}
/*
[1 2 4] [1 3 4]
result：1 ->
[1 2 4] [3 4]
result：1 -> 1 ->
[2 4] [3 4]
result：1 -> 1 -> 2 ->
[4] [3 4]
result：1 -> 1 -> 2 -> 3 ->
[4] [4]
result：1 -> 1 -> 2 -> 3 -> 4 ->
[4] [null]
result：1 -> 1 -> 2 -> 3 -> 4 -> 4
*/
```
