class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==1 ){
            return 1;
        }
        // if(nums.length == 2){
        //     if(nums[0] == nums[1]){
        //         return 1;
        //     }
        // }
        int ans = 1;
        int flag = 0;
        int newArr [] = new int[nums.length]; // all  0
        newArr[0] = nums[0];
        // int exist = nums[0];
        int ptr = 1;
        for(int i = 1;i<nums.length;i++){
            int j = i-1;
            if(nums[i] != nums[j] ){
                newArr[ptr] = nums[i];
                ptr = ptr+1;
                ans++;
                // flag = 1;
            }
        }

        // if(nums[nums.length-1] != nums[nums.length-2]){
        //     newArr[ptr] = nums[nums.length-1];
        //     ans++;
        // }

        for(int i = 0;i<ans;i++){
            nums[i] = newArr[i];
        }
        // if(flag == 0){
        //     return 1;
        // }
        return ans;
    }
}

//  nums = [0,0,1,1,1,2,2,3,3,4]
// nums = [0,0,1,1,1,2,2,3,3,4]
// exist = 0
// newArr = [0,1,2,3,4]
//  1 1 2  ans = 2
// 0 1
// 1 1

// 1 2
// 0
// 1 1 1 1
// ans = 1
// 1 1 2 2 

//ptr = 0
//ans = 1
// newArr = [1 ]
// arr =  1 1 2 