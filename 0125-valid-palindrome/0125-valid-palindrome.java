class Solution {
    public boolean isPalindrome(String s) {
        
        String t = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        
        StringBuilder str = new StringBuilder(t);

        return t.equals(str.reverse().toString());
    }
}
