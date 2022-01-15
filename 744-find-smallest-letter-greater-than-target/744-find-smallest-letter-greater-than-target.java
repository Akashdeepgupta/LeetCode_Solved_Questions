class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0,h= letters.length-1,ans = 0;
        while(l<=h)
        {
            int mid = l + (h-l)/2;
            if(letters[mid] > target)
            {
                ans = mid;
                h = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return letters[ans%letters.length];
    }
}