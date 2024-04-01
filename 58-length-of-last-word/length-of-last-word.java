class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                continue;
            }else{
                for(int j = i;j>=0;j--){
                    if(s.charAt(j) == ' '){
                        return ans;
                    }else{
                        ans++;
                    }
                }
                break;
            }
        }
        return ans;
    }
}