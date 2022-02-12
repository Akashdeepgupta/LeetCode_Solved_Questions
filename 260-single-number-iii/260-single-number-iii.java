class Solution {
    public int[] singleNumber(int[] nums) {
        int a=0,b=0;
        int ab = 0;
        int [] result = new int[2];
       for(int i=0;i<nums.length;i++)
       {
           ab = ab^nums[i];
       }
       ab &= -ab; // find mask
       for(int i=0;i<nums.length;i++)
       {
           if((ab&nums[i]) == 0)
           {
               a ^= nums[i];
           }
           else
           {
               b ^= nums[i];
           }
       }
        result[0] = Math.min(a,b);
        result[1] = Math.max(a,b);
       return result;
    }
}