class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count =1;
        int me = nums[0];
        for(int i =1;i<n;i++)
        {
            if(nums[i] == me)
            {
                count++;
            }
            else if(count == 1)
            {
                me = nums[i];
            }
            else {
                count --;
            }
        }
        return me;
    }
}