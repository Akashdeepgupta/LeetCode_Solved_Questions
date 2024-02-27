/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class pair{
    int ht;
    int dia;
    pair(int ht, int dia){
        this.ht = ht;
        this.dia = dia;
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        pair sol = helper(root);
        return sol.dia;
    }
    public pair helper(TreeNode root){
        if(root == null){
            return new pair(-1,0);
        }
        pair lp = helper(root.left);
        pair rp = helper(root.right);
        pair myp = new pair(0,0);
        myp.ht = Math.max(lp.ht,rp.ht)+1;
        myp.dia = Math.max( Math.max(lp.dia,rp.dia) ,lp.ht+rp.ht+2 );
        return myp;
    }
}