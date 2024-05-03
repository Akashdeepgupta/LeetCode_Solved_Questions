class Solution {
    public int compareVersion(String version1, String version2) {
        String [] arr1 = version1.split("\\.");
        String [] arr2 = version2.split("\\.");
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            int v1 = Integer.parseInt(arr1[ptr1]);
            int v2 = Integer.parseInt(arr2[ptr2]);
            if(v1 < v2){
                return -1;
            }
            else if(v1 > v2){
                return 1;
            }
            ptr1++;
            ptr2++;
        }
        while(ptr1 < arr1.length){
            int val = Integer.parseInt(arr1[ptr1++]);
            if(val > 0){
                return 1;
            }
        }
        while(ptr2 < arr2.length){
            int val = Integer.parseInt(arr2[ptr2++]);
            if(val > 0){
                return -1;
            }
        }
        return 0; 
    }
}