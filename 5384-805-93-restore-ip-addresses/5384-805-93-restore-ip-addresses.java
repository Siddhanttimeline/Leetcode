class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s.length() > 12)
            return result;

        backtrack(result, 0, 0, s, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, int dots, int index, String s, StringBuilder current) {
        if (dots == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); // Remove last "."
            return;
        }

        if (dots >= 4)
            return;

        for (int j = index; j < Math.min(index + 3, s.length()); j++) {
            String segment = s.substring(index, j + 1);

            if (segment.length() > 1 && segment.startsWith("0"))
                continue; // Skip leading zeros
                
            if (Integer.parseInt(segment) > 255)
                continue; // Ensure valid range

            int lenBeforeAppend = current.length();
            current.append(segment).append(".");

            backtrack(result, dots + 1, j + 1, s, current);

            // Backtrack: Remove added segment and dot
            current.setLength(lenBeforeAppend);
        }
    }
}
