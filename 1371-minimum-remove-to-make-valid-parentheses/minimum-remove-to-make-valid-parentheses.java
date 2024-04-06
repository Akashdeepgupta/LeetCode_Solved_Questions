
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(result.length());
                result.append(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    result.append(ch);
                } else {
                    // Mark this closing parenthesis for removal
                    result.append('*');
                }
            } else {
                result.append(ch);
            }
        }

        // Mark any remaining unmatched opening parentheses for removal
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result.setCharAt(idx, '*');
        }

        // Build the final string excluding characters marked for removal
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '*') {
                finalResult.append(result.charAt(i));
            }
        }

        return finalResult.toString();
    }
}
