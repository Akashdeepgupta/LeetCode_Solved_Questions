class Solution {
    public boolean isSubsequence(String s, String t) {
        int max = -1;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = t.indexOf(ch,max+1);
            if(idx > max){
                max = idx;
            }else{
                return false;
            }
        }
        return true;
    }
}