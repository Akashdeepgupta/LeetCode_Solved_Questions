int max(int a, int b){
    if(a > b){
        return a;
    }
    return b;
}

bool canJump(int* nums, int numsSize) {
    int maxReach = 0;
    if(nums[0] == 0 && numsSize>1){
        return false;
    }
    for(int i = 0;i<numsSize-1;i++){
        if(maxReach < i){
            return false;
        }
        maxReach = max(maxReach,i+nums[i]);
    }

    if(maxReach >= numsSize-1){
        return true;
    }
    return false;
}