int sumDigits(int n){
    int sum = 0;
    while(n > 0){
        int rem = n%10;
        sum += rem;
        n = n/10;
    }
    return sum;
}

int minElement(int* nums, int numsSize) {
    int min = INT_MAX;
    for(int i = 0;i<numsSize;i++){
        int sum = sumDigits(nums[i]);
        if(sum < min){
            min = sum;
        }
    }
    return min;
}