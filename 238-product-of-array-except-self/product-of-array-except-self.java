class Solution {
    public int[] productExceptSelf(int[] nums) {
        //remaing to try with O(1) space complexity



        int n = nums.length;
        int [] prefixProduct = new int[n];
        int [] suffixProduct = new int[n];
        int [] output = new int[n];
        prefixProduct[0] = nums[0];
        suffixProduct[n-1] = nums[n-1];
        for(int i = 1;i < n;i++){
            prefixProduct[i] = prefixProduct[i-1]*nums[i];
        }
         for(int i = n-2;i >= 0;i--){
            suffixProduct[i] = suffixProduct[i+1]*nums[i];
        }

        for(int i =0;i<n;i++){
            if(i == 0){
                output[i] = suffixProduct[i+1];
            }
            else if(i == n-1){
                output[i] = prefixProduct[i-1];
            }
            else{
                output[i] = prefixProduct[i-1]*suffixProduct[i+1];
            }
        }

        return output;
    }
}