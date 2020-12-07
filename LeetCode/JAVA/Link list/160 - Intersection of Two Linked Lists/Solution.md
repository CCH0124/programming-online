Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:
<pre>
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
</pre>

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
## code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int a = getLength(headA);
        int b = getLength(headB);

        if ( a > b){
            headA = fastListNode(Math.abs(a-b),headA);
        }else{
            headB = fastListNode(Math.abs(a-b),headB);
        }
        while(headA != null && headB != null){
            if (headA.val == headB.val){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int getLength(ListNode listnode){
        int count = 0;
        while (listnode != null){
            listnode = listnode.next;
            count++;
        }
        return count;
    }
    private ListNode fastListNode(int sub,ListNode longestLink){
        while (sub > 0){
            longestLink = longestLink.next;
            sub--;
        }
        return longestLink;
    }
}
```
