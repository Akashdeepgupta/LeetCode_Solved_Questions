class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1 );
            }
            else{
                hm.put(ch,1);
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0;i<order.length();i++){
            Character ch = order.charAt(i);
            int freq = hm.getOrDefault(ch,0);
            while(freq > 0){
                answer.append(ch);
                freq--;
            }
            hm.remove(ch);
        }

        for(char ch : hm.keySet()){
            int freq = hm.get(ch);
            while(freq > 0){
                answer.append(ch);
                freq--;
            }
        }
        return answer.toString();       
    }
}