class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm1  = new HashMap<>();
        HashMap<Character,Character> hm2  = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            Character ch1 = s.charAt(i);
            Character ch2 = t.charAt(i);
            if(hm1.containsKey(ch1)){
                char mapped = hm1.get(ch1);
                if(mapped != ch2){
                    return false;
                }
            }
            else if(hm2.containsKey(ch2)){
                char mapped = hm2.get(ch2);
                if(mapped != ch1){
                    return false;
                }
            }
            else{
                hm1.put(ch1,ch2);
                hm2.put(ch2,ch1);
            }
        }
        return true;
    }
}