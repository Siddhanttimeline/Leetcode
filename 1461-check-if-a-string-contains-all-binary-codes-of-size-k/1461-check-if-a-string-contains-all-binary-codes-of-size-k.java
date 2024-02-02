class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        if(s.length() < k){
            return false;
        }

        HashSet<String> substring = new HashSet<>();

        for(int i=0; i<= s.length()-k; i++){
            String str = s.substring(i,i+k);
            substring.add(str);
        }

        return substring.size() == Math.pow(2,k);

    }
}