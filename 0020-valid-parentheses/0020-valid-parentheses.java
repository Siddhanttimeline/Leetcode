class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{

                if(stack.empty()){
                    return false;
                }

                if(ch == ')' && stack.peek() != '('){
                    return false;
                }else if(ch == '}' && stack.peek() != '{'){
                    return false;
                }else if(ch == ']' && stack.peek() != '['){
                    return false;
                }else{
                    stack.pop();
                }

            }
        }

        return stack.size() == 0;

    }
}