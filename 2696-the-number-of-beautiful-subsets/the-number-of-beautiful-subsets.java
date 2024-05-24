class Solution {
    int result = 0;
    int K = 0;
    public int beautifulSubsets(int[] nums, int k) {
        K = k;
        HashMap<Integer,Integer> hm = new HashMap<>();
        solve(0,nums,hm);
        return result-1; //excluding empty subset
    }

    public void solve(int idx,int [] nums, HashMap<Integer,Integer> hm){
        if (idx == nums.length) {
            result++;
            return;
        }



        //2 options take the idx element or do not take the idx element

        //not take
        solve(idx+1,nums,hm);

        //take
        //before taking check in hashmap if we can take it or not
        if (!hm.containsKey(nums[idx] - K) && !hm.containsKey(nums[idx] + K)) {
            hm.put(nums[idx], hm.getOrDefault(nums[idx], 0) + 1);
            solve( idx + 1,nums, hm);
            hm.put(nums[idx], hm.get(nums[idx]) - 1);

            // Remove the key if its count drops to 0 to mimic the C++ erase behavior
            if (hm.get(nums[idx]) == 0) {
                hm.remove(nums[idx]);
            }
        }

    }
}