class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        int [] arr = new int[1001];
        int max = -1;
        int ans = -1;
        for(int i = 0;i<n;i++){
            if(nums[i] < 0){
                int x = Math.abs(nums[i]);
                arr[x] = 1;
            }
        }

        for(int i = 0;i<n;i++){
            if(nums[i] > max){
                if(arr[nums[i]] == 1){
                    max = nums[i];
                    ans = nums[i];
                }
            }
        }
        return ans;

    }
}