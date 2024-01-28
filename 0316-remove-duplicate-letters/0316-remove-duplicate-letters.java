class Solution {
    public String removeDuplicateLetters(String s) {

        HashMap<Character, Integer> fMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {

            if (!set.contains(ch)) {
                while (!stack.isEmpty() && ch < stack.peek() && fMap.get(stack.peek()) > 0) {
                    set.remove(stack.pop());
                }

                stack.push(ch);
                set.add(ch);
            }
            fMap.put(ch, fMap.get(ch) - 1);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
