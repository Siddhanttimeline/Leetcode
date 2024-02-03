class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int i=0;
        int j=0;
    
        StringBuilder str = new StringBuilder();

        while(i<word1.length() && j < word2.length()){
            str.append(word1.charAt(i));
            str.append(word2.charAt(j));
            i++;
            j++;
        }

        if(i < word1.length()){
            for(int k = i; k < word1.length(); k++){
                str.append(word1.charAt(k));
            }
        }

        if(j < word2.length()){
            for(int k = j; k < word2.length(); k++){
                str.append(word2.charAt(k));
            }
        }

        return str.toString();

    }
}