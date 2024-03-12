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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp = head;
        int sum = 0;
        while(temp!=null){
            sum = sum+temp.val;
            if(sum == 0){
                return removeZeroSumSublists(temp.next);
            }
            temp = temp.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}