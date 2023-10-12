/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int pivotPoint = 0;
        int ans = -1;
        int n = mountainArr.length();
        pivotPoint = findPeakPoint(mountainArr,0,n-1);
        ans = BinarySearch(mountainArr,0,pivotPoint,target);
        if(ans!=-1){
            return ans;
        }
        ans = BinarySearch2(mountainArr,pivotPoint+1,n-1,target);
        return ans;
    }

    public static int findPeakPoint( MountainArray mountainArr,int start, int end){ // index of the largest element
        int pivotPoint = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if( mountainArr.get(mid) < mountainArr.get(mid+1) ){
                start = mid+1;
            }
            else{
                pivotPoint = mid;
                end = mid-1;
            }
        }
        return pivotPoint;
    }

    public static int BinarySearch(MountainArray mountainArr, int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int BinarySearch2(MountainArray mountainArr, int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                start = mid +1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}