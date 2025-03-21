import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digits, map, result, new StringBuilder());
        return result;
    }

    private void backtrack(int index, String digits, Map<Character, String> map, List<String> result,
            StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(index + 1, digits, map, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
