
class Solution{


   public TreeNode bstToGst(TreeNode root) {
		int[] sum = { total(root) };
		// convert each node value
		convert(root, sum);
		return root;
	}

	private int total(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return total(root.left) + total(root.right) + root.val;
	}

	private void convert(TreeNode root, int[] sum) {
		if (root != null) {
			convert(root.left, sum);
			int temp = root.val;
			root.val = sum[0];
			sum[0] -= temp;
			convert(root.right, sum);
		}
	}
    
}