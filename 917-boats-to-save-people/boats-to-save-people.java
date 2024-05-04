class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] buckets = new int[limit+1];
        for(int p: people) buckets[p]++;
        int start = 0;
        int end = buckets.length - 1;
        int solution = 0;
        while(start <= end) {
            while(start <= end && buckets[start] <= 0) start++;
            while(start <= end && buckets[end] <= 0) end--;
            if(buckets[start] <= 0 && buckets[end] <= 0) break;
            solution++;
            if(start + end <= limit) buckets[start]--; // both start and end can carry on the boat
            buckets[end]--;
        }
        return solution;
    }
}