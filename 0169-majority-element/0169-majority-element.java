class Solution {
    public int majorityElement(int[] nums) {
        int mje = nums[0];
        int count = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == mje){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                mje = nums[i];
                count = 1;
            }
        }
        return mje;
    }
}