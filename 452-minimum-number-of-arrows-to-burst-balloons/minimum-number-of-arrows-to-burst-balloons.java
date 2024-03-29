class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,Comparator.comparingInt( (int []a) -> a[0]).thenComparingInt(a->a[1]) );
        int n = points.length;
        int ans = 0;
        int i = 0;
        while(i<n){
            int end = points[i][1];
            while(i < n && points[i][0] <= end ){
                end = Math.min(end,points[i][1]);
                i++;
            }
            ans++;
        }
        return ans;
    }
}