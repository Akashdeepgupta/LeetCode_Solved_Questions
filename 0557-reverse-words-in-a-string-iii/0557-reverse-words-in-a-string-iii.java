class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int start = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == ' '){
                //add words from i to start in the stringBuilder and add a space
                for(int j = i-1;j>=start;j--){
                    str.append(s.charAt(j));
                }
                str.append(" ");
                start = i+1;
            }
            if(i == n-1){
                for(int j = i;j>=start;j--){
                    str.append(s.charAt(j));
                }
            }
        }
        return str.toString();
    }
}