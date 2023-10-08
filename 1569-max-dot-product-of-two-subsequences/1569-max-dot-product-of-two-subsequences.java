class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // DP Question
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp = new int[m][n];
        dp[0][0] = nums1[0]*nums2[0];

        //fill 1st column
        for(int i = 1;i<dp.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],nums2[i]*nums1[0]);
        }

        //fill 1st row
        for(int j = 1;j<dp[0].length;j++){
            dp[0][j] = Math.max(dp[0][j-1],nums1[j]*nums2[0]);
        }

        //fill remaining matrix
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                int top = dp[i-1][j];
                int left = dp[i][j-1];
                int currentMultiplication = nums1[j]*nums2[i];
                int diagonal = dp[i-1][j-1];
                int diagonalPlusCurrent = diagonal+currentMultiplication;
                dp[i][j] = max(top,left,currentMultiplication,diagonal,diagonalPlusCurrent);
                // dp[i][j] = Math.max( top, Math.max(left, Math.max(currentMultiplication,Math.max(diagonal,diagonalPlusCurrent ) ) ) );
            }
        }
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }

    public static int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }
        return max;
    }

}