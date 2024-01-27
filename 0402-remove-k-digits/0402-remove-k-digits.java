class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        
        int n = num.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            // we are maintaining a monotonic stack here
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // if we still have something left in k then use it and remove from the stack
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder s = new StringBuilder();

        for (Character val : stack) {
            s.append(val);
        }

        // removing leading zeroes from the string
        while (s.length() > 1 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }

        return s.toString();
    }
}
