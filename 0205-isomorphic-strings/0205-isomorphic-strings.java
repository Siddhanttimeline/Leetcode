class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> reverseMap = new HashMap<>();

        int i=0,j=0;

        while( i<s.length() ){
            char charS = s.charAt(i);
            char charT = t.charAt(j);

            if(!map.containsKey(charS)){
                map.put(charS,charT);
            }else{
                if(map.get(charS) != charT){
                    return false;
                }
            }

            if( !reverseMap.containsKey(charT)){
                reverseMap.put(charT,charS);
            }else{
                if(reverseMap.get(charT) != charS){
                    return false;
                }
            }

            i++;
            j++;

        }

        return true;

    }
}