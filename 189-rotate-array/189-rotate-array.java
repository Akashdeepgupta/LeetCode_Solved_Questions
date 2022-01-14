class Solution {
    public void rotate(int[] nums, int k) {
        //RightShift(nums,k);
        int A = nums.length;
        int to_Rotate = k%A;
        reverse(nums,0,A-1);
        reverse(nums,0,to_Rotate-1);
        reverse(nums,to_Rotate,A-1);
    }
    
    static void reverse(int [] arr,int start, int end)
    {
        while(start < end)
        {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int [] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
    
//     static void RightShift(int [] arr,int k)
//     {
//         int n = arr.length;
//         while(k-- > 0)
//         {
//             for (int i = n-1; i > 0 ; i--) {
//                 swap(arr,i,i-1);
//             }
//         }

//     }
    
//     static void swap(int [] arr, int first, int second)
//     {
//         int temp = arr[first];
//         arr[first] = arr[second];
//         arr[second] = temp;
//     }
    
// }