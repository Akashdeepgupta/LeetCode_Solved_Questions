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
 //approach 2 
//  using map, linear approach
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> hm = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        hm.put(0,dummy);

        while(head != null){
            prefixSum = prefixSum + head.val;

            if(hm.containsKey(prefixSum)){
                ListNode start = hm.get(prefixSum);
                ListNode temp = start;
                int sum = prefixSum;
                while(temp!=head){
                    temp = temp.next;
                    sum = sum + temp.val;
                    if(temp!=head){
                        hm.remove(sum);
                    }
                }
                start.next = head.next;
            }
            else{
                hm.put(prefixSum,head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}