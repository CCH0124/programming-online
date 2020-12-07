Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
<pre>
Input: 1->1->2
Output: 1->2
</pre>
Example 2:
<pre>
Input: 1->1->2->3->3
Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
        
    }
}
/*
[1,1,2,2,3,4,2]
1 2 2 3 4 2
1 2 3 4 2
1 2 3 4 2
1 2 3 4 2
1 2 3 4 2
*/
```
