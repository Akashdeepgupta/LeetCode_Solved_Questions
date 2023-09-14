class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int [][] dp = new int[n][m];
        //BR
        if(dungeon[n-1][m-1] >= 0 ){
            dp[n-1][m-1] = 1;
        }
        else{
            dp[n-1][m-1] = Math.abs(dungeon[n-1][m-1])+1;
        }
        //last column
        for(int i = n-2;i>=0;i--){
            dp[i][m-1] = Math.max(1,dp[i+1][m-1]-dungeon[i][m-1]);
        }
        //last row
        for(int j = m-2;j>=0;j--){
            dp[n-1][j] = Math.max(1,dp[n-1][j+1]-dungeon[n-1][j]);
        }
        //matrix
        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                dp[i][j] = Math.max(1, Math.min( dp[i+1][j],dp[i][j+1] )-dungeon[i][j] );
            }
        }
        return dp[0][0];
    }
}