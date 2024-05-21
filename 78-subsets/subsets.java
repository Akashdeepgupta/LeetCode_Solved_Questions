class Solution {
    public List<List<Integer>> subsets(int[] a) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            List<Integer> sol = new ArrayList<>();
            int temp = i;
            int ptr = 0;
            while(temp>0){
                int rem = temp%2;
                temp = temp/2;
                if(rem > 0){
                    sol.add(a[ptr]);
                }
                ptr++;
            }
            ans.add(sol);
        }
        return ans;
    }
}