class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            pQueue.add((long)nums[i]);
        }
        int ans = 0;
        while(pQueue.peek() < k){
            ans++;
            long first = pQueue.poll();
            long second = pQueue.poll();
            long operation = Math.min(first,second)*2 + Math.max(first,second);
            pQueue.add(operation);
        }
        return ans;
    }
}