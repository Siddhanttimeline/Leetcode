class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() > 12)
            return result;

        backtrack(0, 0, new StringBuilder(), s, result);
        return result;
    }

    private void backtrack(int index, int dots, StringBuilder current, String s, List<String> result ) {
        if (dots == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }

        if (dots >= 4)
            return;

        for (int j = index; j < Math.min(index + 3, s.length()); j++) {
            String segment = s.substring(index, j + 1);

            if (segment.length() > 1 && segment.startsWith("0"))
                continue; // leading zeroes

            if (Integer.parseInt(segment) > 255)
                continue;   // invalid interger value

            int lenBeforeAppend = current.length();

            current.append(segment).append(".");

            backtrack(j + 1, dots + 1, current, s, result);

            current.setLength(lenBeforeAppend);
        }
    }
}