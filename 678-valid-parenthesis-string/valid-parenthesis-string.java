class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch =='('){
                openStack.push(i);
            }
            else if(ch == '*'){
                starStack.push(i);
            }else{
                // if we find close bracket
                if(!openStack.isEmpty()){
                    openStack.pop();
                }
                else if(!starStack.isEmpty() && starStack.peek() < i){
                    starStack.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openStack.isEmpty()){
            if(!starStack.isEmpty() && openStack.peek() < starStack.peek()){
                openStack.pop();
                starStack.pop();
            }
            else{
                return false;
            }
        }
        if(openStack.isEmpty()){
            return true;
        }
        return false;
    }
}