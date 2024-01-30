class Solution {
    public String reverseWords(String s) {

        String[] arr = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(String str : arr){
            StringBuilder str1 = new StringBuilder(str);
            result.append(str1.reverse());
            result.append(" ");
        }

        return result.toString().trim();
    }
}