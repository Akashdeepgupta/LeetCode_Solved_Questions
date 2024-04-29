class Solution {
    public int minOperations(int[] nums, int k) {
        int totalXor = 0;
        int n = nums.length;
        int operations = 0;
        for(int i = 0;i<n;i++){
            totalXor = totalXor ^ nums[i];
        }

        for(int i = 0;i<32;i++){
            int bitAtXor = checkBit(totalXor,i);
            int bitAtK = checkBit(k,i);
            if(bitAtXor != bitAtK){
                operations++;
            }
        }
        return operations;
    }

    public int checkBit(int number, int position){
        int temp = number;
        temp = temp>>position;
        if( (temp&1) == 0 ){
            return 0;
        }
        return 1;
    }
}