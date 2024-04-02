class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split("[' ']");
        if(word.length != pattern.length()){
            return false;
        }
        HashMap<Character,String> hm = new HashMap<>();
        HashMap<String,Character> hmw = new HashMap<>();
        for(int i = 0;i<pattern.length();i++){

            Character ch = pattern.charAt(i);
            if(hm.containsKey(ch)){
                String mapped = hm.get(ch);
                if(!mapped.equals(word[i])){
                    return false;
                }
            }
            else if(hmw.containsKey(word[i])){
                Character mapped = hmw.get(word[i]);
                if(mapped!=ch){
                    return false;
                }
            }
            else{
                hm.put(ch,word[i]);
                hmw.put(word[i],ch);
            }
        }
        return true;
    }
}