class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String str : logs) {
            if (stack.isEmpty() && !str.equals("../") && !str.equals("./")) {
                stack.push(str);
            } else {
                if (!stack.isEmpty() && str.equals("../")) {
                    stack.pop();
                } else if (!stack.isEmpty() && !str.equals("./")) {
                    stack.push(str);
                }
            }
        }

        return stack.size();
    }
}
