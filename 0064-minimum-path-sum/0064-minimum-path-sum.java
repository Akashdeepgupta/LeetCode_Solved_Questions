class Solution {
    public int minPathSum(int[][] A) {
         int n = A.length;
        int m = A[0].length;
        int [][] dp = new int[n][m];
        dp[0][0] = A[0][0];
        //columns
        for(int i = 1;i<m;i++){
            dp[0][i] = dp[0][i-1]+A[0][i];
        }
        //rows
        for(int i = 1;i<n;i++){
            dp[i][0] = dp[i-1][0]+A[i][0];
        }
        //matrix
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[i][j] = Math.min(dp[i][j-1] , dp[i-1][j])+A[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}