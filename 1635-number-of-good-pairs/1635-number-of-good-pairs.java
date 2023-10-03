class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        // element -> freq
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }

        for(HashMap.Entry<Integer,Integer> entry : hm.entrySet()){
            int value = entry.getValue();
            if(value > 1){
                count = count + (value*(value-1))/2;
            }
        }
        return count;
    }
}