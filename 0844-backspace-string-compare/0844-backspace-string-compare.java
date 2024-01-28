import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (perform(s).equals(perform(t))) {
            return true;
        } else {
            return false;
        }
    }

    public static String perform(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (stack.isEmpty()) {
                if (ch != '#') {
                    stack.push(ch);
                }
            } else {
                if (ch == '#') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}
