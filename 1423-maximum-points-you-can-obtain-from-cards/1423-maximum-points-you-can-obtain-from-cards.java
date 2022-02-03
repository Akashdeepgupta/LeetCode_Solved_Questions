class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum =0,ans = 0;
        for(int i = 0;i<k;i++)
        {
            sum = sum+cardPoints[i];
        }
        ans = sum;
        int i = k-1; int j = cardPoints.length-1;
        while(i>=0)
        {
            sum = sum-cardPoints[i];
            sum = sum+cardPoints[j];
            i--;j--;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}