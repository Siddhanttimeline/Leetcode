class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int j=0;
        Stack<Integer> stack = new Stack<>();

        for(int num : pushed){
           stack.push(num);

           while(!stack.isEmpty() && stack.peek() == popped[j]){
               stack.pop();
               j++;
           }

        }

        return stack.isEmpty();

    }
}