class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        int ans = 0;
        int n = apple.length;
        for(int i = 0;i<n;i++){
            sum += apple[i];
        }
        Arrays.sort(capacity);
        int ptr = capacity.length-1;
        while(sum > 0){
            sum = sum - capacity[ptr--];
            ans++;
        }
        return ans;
    }
}