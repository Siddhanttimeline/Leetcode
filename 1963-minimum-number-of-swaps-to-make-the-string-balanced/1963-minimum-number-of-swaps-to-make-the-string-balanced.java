class Solution {
    public int minSwaps(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '['){
                stack.push(ch);
            }else{

                if( !stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }

        }

        int openBrackets = stack.size()/2;
        return (openBrackets+1)/2;

    }
}