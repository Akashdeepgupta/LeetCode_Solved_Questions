class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int [] pfm = new int[n];
        int maxp = height[0];
        int [] sfm = new int[n];
        int maxs = height[n-1];
        pfm[0] = height[0];
        for(int i = 1;i<n;i++)
        {
            if(height[i] > maxp)
            {
                maxp = height[i];
            }
            pfm[i] = maxp;
        }
        sfm[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--)
        {
            if(height[i] > maxs)
            {
                maxs = height[i];
            }
            sfm[i] = maxs;
        }
        for(int i =1;i<n-1;i++)
        {
            int lmax = pfm[i];
            int rmax = sfm[i];
            int hlevel = Math.min(lmax,rmax);
            int wlevel = hlevel-height[i];
            if(wlevel >= 0)
            {
                ans += wlevel;
            }
        }
        return ans;
    }
}