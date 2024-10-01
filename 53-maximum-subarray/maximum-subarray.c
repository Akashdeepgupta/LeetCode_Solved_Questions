int max(int a, int b){
    if(a>b){
        return a;
    }
    return b;
}

int maxSubArray(int* nums, int numsSize) {
    int sum = 0;
    int ans = INT_MIN;
    for(int i = 0;i<numsSize;i++){
        if(sum < 0){
            sum = 0;
        }
        sum = sum+nums[i];
        ans = max(ans,sum);
    }
    return ans;
}