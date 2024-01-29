class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        String result = "";
        int range = Math.min(strs[0].length(),strs[strs.length-1].length());

        for(int i=0; i<range; i++){
            if(strs[0].charAt(i)== strs[strs.length-1].charAt(i)){
                result += strs[0].charAt(i);
            }else{
                return result;
            }
        }

        return result;

    }
}