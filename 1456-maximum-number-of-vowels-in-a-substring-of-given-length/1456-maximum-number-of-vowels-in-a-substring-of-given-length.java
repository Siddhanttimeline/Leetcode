class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (vowels.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if (right - left + 1 >= k) {
                int vowelsCount = 0;
                for (char c : map.keySet()) {
                    vowelsCount += map.get(c);
                }
                ans = Math.max(ans, vowelsCount);

                char chL = s.charAt(left);
                if (map.containsKey(chL)) {
                    map.put(chL, map.get(chL) - 1);
                    if (map.get(chL) == 0) {
                        map.remove(chL);
                    }
                }

                left++;
            }
            right++;
        }
        return ans;
    }
}
