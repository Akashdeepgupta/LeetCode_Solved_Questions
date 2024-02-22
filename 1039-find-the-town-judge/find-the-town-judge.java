class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        if(trust.length == 0)
            return -1;
        
        int ans [] = new int[1001];
        boolean [] truster = new boolean[1001];
        for(int i = 0;i<trust.length;i++){
            ans[trust[i][1]]++;
            truster[trust[i][0]] = true;
        }
        for(int i = 0;i<ans.length;i++){
            if( (ans[i] == n-1) && (truster[i] == false) ){
                return i;
            }
        }
        return -1;
    }
}