class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int toSelect = k;
        int ptr = happiness.length-1;
        int toMinus = 0;
        while(k > 0){
            int toAdd = (happiness[ptr]-toMinus)>=0 ? (happiness[ptr]-toMinus) : 0;
            sum = sum + toAdd;
            toMinus++;
            k--;
            ptr--;
        }
        return sum;
    }
}