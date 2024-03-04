class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int ans = 0;
        int score = 0;
        int ptr1 = 0;
        int ptr2 = n-1;
        Arrays.sort(tokens);
        while(ptr1 <= ptr2){
            if(power>=tokens[ptr1]){
                power = power - tokens[ptr1];
                score++;
                ans = Math.max(ans,score);
                ptr1++;
            }
            else if(score>=1){
                power = power + tokens[ptr2];
                score--;
                ptr2--;
            }
            else{
               return ans;
            }
        }
        return ans;
    }
}