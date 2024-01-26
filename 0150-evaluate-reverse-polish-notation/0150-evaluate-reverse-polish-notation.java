class Solution {
    public int evalRPN(String[] tokens) {
        

        Stack<Integer> stack = new Stack<>();

        for(String str : tokens){
            if(str.equals("+")){
                int fE = stack.pop();
                int sE = stack.pop();
                int result = sE + fE;
                stack.push(result);
            }else if(str.equals("-")){
                int fE = stack.pop();
                int sE = stack.pop();
                int result = sE - fE;
                stack.push(result);
            }else if(str.equals("*")){
                int fE = stack.pop();
                int sE = stack.pop();
                int result = sE * fE;
                stack.push(result);
            }else if(str.equals("/")){
                int fE = stack.pop();
                int sE = stack.pop();
                if(fE != 0){
                    int result = sE / fE ;
                    stack.push(result);
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }


        return stack.peek();

    }
}