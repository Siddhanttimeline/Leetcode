class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int maxLength = 0; 
        HashSet<Character> set = new HashSet<>();

        while( j < s.length() ){
            char ch = s.charAt(j);

            if(!set.contains(ch)){
                set.add(ch);
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}