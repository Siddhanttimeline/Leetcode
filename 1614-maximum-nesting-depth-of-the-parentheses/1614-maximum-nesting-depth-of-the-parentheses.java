class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int tempCount = 0;

        // Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // stack.push(ch);
                tempCount += 1;
            } else if (ch == ')') {
                // stack.pop();
                tempCount -= 1;
            }

            count = Math.max(count, tempCount);
        }

        return count;
    }
}
