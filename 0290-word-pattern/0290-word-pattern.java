class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] arr = s.split(" ");
       
        if(pattern.length() != arr.length){
            return false;
        }

        HashMap<Character,String> mapping = new HashMap<>();
        HashMap<String,Character> reverseMapping = new HashMap<>();

        int pointer = 0;

        for(String str : arr){
            char ch = pattern.charAt(pointer);

            if( !mapping.containsKey(ch)){
                mapping.put(ch,str);
            }else{
                if(!mapping.get(ch).equals(str)){
                    return false;
                }
            }

            if(!reverseMapping.containsKey(str)){
                reverseMapping.put(str,ch);
            }else{
                if( reverseMapping.get(str) != ch){
                    return false;
                }
            }
            pointer++;

        }

        return true;


    }
}