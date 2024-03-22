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
    public boolean isPalindrome(ListNode head) {
         int n = length(head);
        int[]arr = new int[n];
        ListNode temp = head;
        int i = 0;
        while(temp!=null){
            arr[i++] = temp.val;
            temp = temp.next;
        }
        for( i = 0;i<n/2;i++){
            if(arr[i] != arr[n-i-1]){
                return false;
            }
        }
        return true;
    }
    public int length(ListNode A){
        int len = 0;
        ListNode temp = A;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        return len;
    }
}