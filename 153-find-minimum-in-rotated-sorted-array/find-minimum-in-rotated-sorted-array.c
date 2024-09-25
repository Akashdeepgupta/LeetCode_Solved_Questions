
int minimum(int a, int b){
    if(a < b){
        return a;
    }
    return b;
}

int findMin(int* nums, int numsSize) {
    int n = numsSize;
    int s = 0;
    int e = n-1;
    int min = 6000;
    while(s<=e){
        int mid = (s+e)/2;
        min = minimum(min,nums[mid]);
        if( (nums[e] < nums[s]) && (nums[mid] > nums[e]) ){
            s = mid+1;
        }
        else{
            e = mid-1;
        }
    }

    return min;
}