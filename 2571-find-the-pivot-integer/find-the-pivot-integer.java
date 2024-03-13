class Solution {
    public int pivotInteger(int n) {
        int p1 = 1;
        int p2 = n;
        while(p1<=p2){
            int mid = (p1+p2)/2;
            int leftSum = mid*(mid+1)/2;
            int rightSum = n*(n+1)/2 - (mid-1)*(mid)/2 ;
            if(leftSum == rightSum){
                return mid;
            }
            else if(leftSum < rightSum){
                p1 = mid+1;
            }
            else{
                p2 = mid-1;
            }
        }
        return -1;
    }
}