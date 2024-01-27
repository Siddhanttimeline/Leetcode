class Pair {
    Character x;
    int y;

    Pair(Character x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().x == ch) {
                int increasedCount = stack.peek().y + 1;
                stack.push(new Pair(ch, increasedCount));
                if (increasedCount == k) {
                    while (increasedCount > 0) {
                        stack.pop();
                        increasedCount--;
                    }
                }
            } else {
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder str = new StringBuilder();
        for (Pair p : stack) {
            str.append(p.x);
        }

        return str.toString();
    }
}
