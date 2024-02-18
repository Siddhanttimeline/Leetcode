class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        
        for (int val : arr1) {
            String str = Integer.toString(val);
            for (int j = 0; j < str.length(); j++) {
                set.add(str.substring(0, j + 1));
            }
        }

        int size = 0;
        for (int val : arr2) {
            String str = Integer.toString(val);

            for (int j = 0; j < str.length(); j++) {
                String s = str.substring(0, j + 1);
                if (set.contains(s)) {
                    if (size < s.length()) {
                        size = s.length();
                    }
                }
            }
        }

        return size;
    }
}
