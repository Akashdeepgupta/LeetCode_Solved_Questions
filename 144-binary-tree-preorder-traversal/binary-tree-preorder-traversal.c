/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void traverse(struct TreeNode* root, int *arr,int* returnSize){
    if(root!=NULL){
        arr[*returnSize] = root->val;
        (*returnSize)++;
        traverse(root->left,arr,returnSize);
        traverse(root->right,arr,returnSize);
    }
}

int* preorderTraversal(struct TreeNode* root, int* returnSize) {
    int *arr = (int *)malloc(sizeof(int)*100);
    *returnSize = 0;
    traverse(root,arr,returnSize);
    return arr;
}