class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        StringBuilder answer = new StringBuilder();
        boolean [] taken = new boolean[26];
        int [] lastIdx = new int[26];
        Arrays.fill(lastIdx,-1);

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            lastIdx[idx] = i;
        }

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            if(taken[idx]){
                continue;
            }
            while(answer.length()>0 && answer.charAt(answer.length()-1) > ch && lastIdx[answer.charAt(answer.length()-1) - 'a'] > i ){
                taken[answer.charAt(answer.length()-1)-'a'] = false;
                answer.deleteCharAt(answer.length()-1);
            }
            answer.append(ch);
            taken[idx] = true;
        }
        return answer.toString();
    }
}