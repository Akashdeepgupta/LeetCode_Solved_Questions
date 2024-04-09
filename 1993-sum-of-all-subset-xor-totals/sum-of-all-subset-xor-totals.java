class Solution {
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        int ans = helper(0,nums,al);
        return ans;
    }

    public int helper(int index, int [] nums,ArrayList<Integer> al){
        if(index == nums.length){
            int xorOfArray = xorOp(al);
            return xorOfArray;
        }
        int ans = 0;
        al.add(nums[index]);
        ans = ans+helper(index+1,nums,al);
        al.remove(al.size()-1);
        ans = ans+helper(index+1,nums,al);
        return ans;
    }

    public int xorOp(ArrayList<Integer> al){
        int n = al.size();
        if(n == 0){
            return 0;
        }
        int xor = al.get(0);
        for(int i =1;i<n;i++){
            xor = xor^al.get(i);
        }
        return xor;
    }
}