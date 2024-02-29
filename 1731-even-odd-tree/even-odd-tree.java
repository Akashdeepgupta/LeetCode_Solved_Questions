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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int rem = 1;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                li.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(check(li,rem) == false){
                return false;
            }
            rem = Math.abs(rem-1);
        }
        return true;
    }

    public boolean check(List<Integer> li, int rem){
        int n = li.size();
        if(rem == 1){
            int max = 0;
            for(int i = 0;i<n;i++){
                if(li.get(i)%2 == 0){
                    return false;
                }
                if(li.get(i) <= max ){
                    return false;
                }
                else{
                    max = li.get(i);
                }
            }
        }
        else{
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                if(li.get(i)%2 == 1){
                    return false;
                }
                if(li.get(i) >= min ){
                    return false;
                }
                else{
                    min = li.get(i);
                }
            }
        }
        return true;
    }
}