class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int max = 0;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i<=j){
            int sum = 0;
            sum = people[i]+people[j];
            if(i==j){
                ans++;
                break;
            }
            if(sum <= limit){
                ans++;
                i++;
                j--;
            }
            else {
                ans++;
                j--;
            }
        }
        return ans;
    }
}
// 1 2 2 3