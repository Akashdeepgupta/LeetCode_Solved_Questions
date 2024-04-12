class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int prefix_max_sum [] = new int [n];
        int suffix_max_sum [] = new int [n];

        prefix_max_sum[0] = height[0];
        for(int i = 1;i<n;i++){
            if(height[i] > prefix_max_sum[i-1]){
                prefix_max_sum[i] = height[i];
            }
            else{
                prefix_max_sum[i] = prefix_max_sum[i-1];
            }
        }

        suffix_max_sum[n-1] = height[n-1];
        for(int i = n-2; i>0;i--){
            if(height[i] > suffix_max_sum[i+1]){
                suffix_max_sum[i] = height[i];
            }
            else{
                suffix_max_sum[i] = suffix_max_sum[i+1];
            }
        }

        for(int i = 1;i<n;i++){
            int MaxLeftHeight = prefix_max_sum[i];
            int MaxRightHeight = suffix_max_sum[i];
            int MaxAvailableHeight = Math.min(MaxLeftHeight,MaxRightHeight);
            int VolumeAtThatElement = MaxAvailableHeight - height[i];
            if(VolumeAtThatElement > 0){
                ans += VolumeAtThatElement;
            }
        }
        return ans;
    }
}