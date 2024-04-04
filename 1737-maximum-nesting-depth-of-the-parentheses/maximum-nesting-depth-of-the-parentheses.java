class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i =0;i<n;i++){
            Character ch = s.charAt(i);
            if(ch == '('){
                stk.push(ch);
                depth = Math.max(depth,stk.size());
            }
            else if(ch == ')'){
                if(!stk.isEmpty() && stk.peek() == '('){
                    stk.pop();
                }
            }
        }
        return depth;
    }
}