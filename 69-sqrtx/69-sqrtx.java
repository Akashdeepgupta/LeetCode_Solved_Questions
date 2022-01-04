class Solution {
    public int mySqrt(int x) {
        return (int)Binsearchforsqrt(x);
    }
    
    static long Binsearchforsqrt(int x)
    {
        long l = 0, h =x;
        long ans  = 0;
        while(l<=h)
        {
            long mid = l + (h-l)/2;
            if(mid*mid <= x)
            {
                ans = mid;
                l = mid+1;
            }
            else if(mid*mid > x)
            {
                h = mid-1;
            }
        }
        return ans;
    }

    
}