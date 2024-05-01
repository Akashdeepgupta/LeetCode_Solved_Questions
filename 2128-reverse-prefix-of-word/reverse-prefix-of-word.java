class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        int i = 0;
        StringBuilder str  = new StringBuilder();
        for( i = 0;i<n;i++){
            char toFind = word.charAt(i);
            str.append(toFind);
            if(toFind == ch){
                str = str.reverse();
                break;
            }
        }
        i++;
        while(i<n){
            str.append(word.charAt(i));
            i++;
        }
        return str.toString();
    }
}