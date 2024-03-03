/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);
         if(size == n){
            head = head.next;
            return head;
        }
        if(size == 1){
            return null;
        }
        if(size==2){
            head.next = null;
            return head;
        }
       
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode t3 = head.next.next;
        int toIterate = size-n-1;
        for(int i = 1;i<=toIterate;i++){
            t1 = t2;
            t2 = t3;
            t3 = t3.next;
        }
        t1.next = t3;
        return head;
    }

    public int length(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}