class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx,-1);
        boolean[] taken = new boolean[26];
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            lastIdx[idx] = i;
        }

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            if(taken[idx] == true){
                continue;
            }
            while(result.length() >0 && result.charAt(result.length()-1) > ch  && lastIdx[result.charAt(result.length()-1)-'a'] > i ){
                taken[result.charAt(result.length()-1) -'a'] = false;
                result.deleteCharAt(result.length()-1);
            }
            result.append(ch);
            taken[idx] = true;

        }
        return result.toString();
    }
}