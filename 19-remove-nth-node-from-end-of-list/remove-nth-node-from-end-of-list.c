/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode *temp = head;
    struct ListNode *t1 = head;
    struct ListNode *prev = head;
    while(n>0){
        temp = temp->next;
        --n;
    }
    if(temp == NULL){
        return prev->next;
    }
    while(temp->next != NULL){
        prev = prev->next;
        temp= temp->next;
    }
    prev->next = prev->next->next;
    return head;
}