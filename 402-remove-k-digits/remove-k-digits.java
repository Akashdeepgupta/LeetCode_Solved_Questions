class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k){
            return "0";
        }
        Stack<Integer> stk = new Stack<>();
        char ch = num.charAt(0);
        int temp = ch-'0';
        stk.push(temp);
        for(int i = 1;i<n;i++){
            ch = num.charAt(i);
            temp = ch-'0';
            while(!stk.isEmpty() && k > 0 && temp < stk.peek()){
                stk.pop();
                k--;
            }
            stk.push(temp);
        }
        while(k>0){
            stk.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!stk.isEmpty()){
            int x = stk.pop();
            char xc = (char)(x + '0');
            str.append(xc);
        }
        str = str.reverse();
        int count = 0;
        int flag = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                count++;
            }
            else if(count > 0){
                flag = 1;
                break;
            }
            else{
                break;
            }
        }
        if(count == str.length()){
            return "0";
        }
        if(flag == 1){
            while(count > 0){
                str.deleteCharAt(0);
                count--;
            }
        }
        return str.toString();
    }
}