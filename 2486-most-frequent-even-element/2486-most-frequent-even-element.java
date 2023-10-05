class Solution {
    public int mostFrequentEven(int[] nums) {
        int [] count = new int[100001];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2 == 0){
                count[nums[i]]++;
            }
        }
        int ans = -1;
        int max = 1;
        for(int i = 100000;i>=0;i = i-2){
            if(count[i] >= max){
                max = count[i];
                ans = i;
            }
        }
        return ans;
    }
}