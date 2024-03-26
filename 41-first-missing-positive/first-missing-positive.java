class Solution {
    public int firstMissingPositive(int[] nums) {
        int flag = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                flag = 1;
            }
        }
        if(flag ==0){
            return 1;
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        for(int i = 0;i<nums.length;i++){
            int abs_ind = Math.abs(nums[i])-1;
            nums[abs_ind] =  Math.abs(nums[abs_ind])*-1;
        }
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return nums.length+1;
    }
}