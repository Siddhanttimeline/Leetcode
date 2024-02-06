class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }

        int left = 0;

        int[] pHash = new int[26];
        for (char ch : p.toCharArray()) {
            pHash[ch - 'a']++;
        }

        int[] sHash = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            sHash[ch - 'a']++;

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(sHash, pHash)) {
                    list.add(left);
                }

                sHash[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return list;
    }
}
