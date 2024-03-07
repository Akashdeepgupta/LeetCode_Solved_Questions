class Solution {
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int mid = length/2;
       
        ListNode temp = head;
        while(mid>0){
            temp = temp.next;
            mid--;
        }
        return temp;
    }

    public static int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
}