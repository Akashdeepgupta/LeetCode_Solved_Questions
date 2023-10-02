class Solution {
    public boolean winnerOfGame(String colors) {
        int TripletsOfA = 0;
        int TripletsofB = 0;
        for(int i = 1;i < colors.length()-1;i++){
            char first = colors.charAt(i-1);
            char second = colors.charAt(i);
            char third = colors.charAt(i+1);
            if(second == 'A' && second == first && second == third){
                TripletsOfA++;
            }
            else if(second == 'B' && second == first && second == third){
                TripletsofB++;
            }
        }
        if(TripletsofB >= TripletsOfA){
            return false;
        }
        return true;
    }
}