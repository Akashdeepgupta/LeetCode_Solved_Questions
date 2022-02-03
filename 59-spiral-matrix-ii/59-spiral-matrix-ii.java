class Solution {
    public int[][] generateMatrix(int n) {
        int [][]sol = new int[n][n];
        int l = 0,r=n-1,t=0,b=n-1;
        int count = 1;
        while(l<=r && t<=b)
        {
            for(int i=l;i<=r;i++)
            {
                sol[t][i] = count++;
            }
            t++;
            for(int i=t;i<=b;i++)
            {
                sol[i][r] = count++;
            }
            r--;
            for(int i = r; i>=l;i--)
            {
                sol[b][i] = count++;
            }
            b--;
            for(int i =b; i>=t;i--)
            {
                sol[i][l] = count++;
            }
            l++;
        }
        return sol;
    }
}