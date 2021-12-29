class Solution {
    public boolean isPerfectSquare(int num) {
        return IsPerfectSquare(num);
    }
    
    
    static boolean IsPerfectSquare(int x)
    {
        long l = 0,h=x;
        long ans = 0;
        while(l<=h)
        {
            long mid = l + (h-l)/2;
            if(mid*mid <= x)
            {
                ans = mid;
                l = mid+1;
            }
            else
            {
                h = mid-1;
            }
        }
        if(ans*ans == x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    
}