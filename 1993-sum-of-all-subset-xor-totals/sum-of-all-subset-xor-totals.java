class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = helper(0,nums,0);
        return ans;
    }

    public int helper(int index, int [] nums,int xor){
        if(index == nums.length){
            return xor;
        }
        int withElement = helper(index+1,nums,xor^nums[index]);
        int withoutElement = helper(index+1,nums,xor);
        return withElement+withoutElement;
    }
}