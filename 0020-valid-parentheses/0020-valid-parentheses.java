class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        for(int i = 0;i<l;i++){
            Character ch = s.charAt(i);
            if(ch.equals('(') || ch.equals('{') || ch.equals('[') ){
                st.push(ch);
            }
            else if(ch.equals(')')){
                if(!st.isEmpty() && st.peek().equals('(')){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
            else if(ch.equals('}')){
                if(!st.isEmpty() && st.peek().equals('{')){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
            else if(ch.equals(']')){
                if( !st.isEmpty() && st.peek().equals('[')){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}