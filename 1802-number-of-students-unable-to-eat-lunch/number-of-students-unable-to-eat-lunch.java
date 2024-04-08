class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count1 = 0;
        int count0 = 0;
        int n = students.length;
        for(int i =0 ;i<n;i++){
            if(students[i] == 1){
                count1++;
            }
            else{
                count0++;
            }
        }
        for(int i =0;i<n;i++){
            int toEat = sandwiches[i];
            if(toEat == 1){
                if(count1>0){
                    count1--;
                }
                else{
                    break;
                }
            }
            if(toEat == 0){
                if(count0 > 0){
                    count0--;
                }
                else{
                    break;
                }
            }
        }
        return count1+count0;
    }
}