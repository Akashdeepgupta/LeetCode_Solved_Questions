class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count = 0;
        count = countOnes(s);
        StringBuilder sol = new StringBuilder();
        int addones = count -1;
        while(addones > 0){
            sol.append("1"); 
            addones--;
        }
        int addzeros = n-count;
        while(addzeros > 0){
            sol.append("0");
            addzeros--;
        }
        sol.append("1");
        return sol.toString();
    }

    public int countOnes(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}