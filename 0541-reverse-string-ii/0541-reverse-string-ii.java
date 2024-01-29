class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k, n);

            StringBuilder str = new StringBuilder(s.substring(start, end)).reverse();
            result.append(str);

            result.append(s.substring(end, Math.min(i + 2 * k, n)));
        }

        return result.toString();
    }
}
