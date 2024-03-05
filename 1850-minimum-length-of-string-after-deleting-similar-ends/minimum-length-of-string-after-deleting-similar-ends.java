class Solution {
    public int minimumLength(String s) {
        int ptr1 = 0;
        int ptr2 = s.length()-1;
        while(ptr1<ptr2 && s.charAt(ptr1) == s.charAt(ptr2)){
            char ch = s.charAt(ptr1);
            while(ptr1 < ptr2 && s.charAt(ptr1) == ch){
                ptr1++;
            }
            while(ptr2>=ptr1 && s.charAt(ptr2) == ch){
                ptr2--;
            }
        }
        return ptr2-ptr1+1;
    }
}