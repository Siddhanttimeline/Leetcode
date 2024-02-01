class Solution {

    public int countPalindromicSubsequence(String s) {

        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashSet<String> set = new HashSet<>();
        HashSet<Character> leftSet = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0; i<s.length()-1; i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)) map.put(ch,map.get(ch)-1);
    
            if(map.get(ch) == 0) map.remove(ch);

            for(int k=0; k<26; k++){
                if( leftSet.contains(letters[k]) && map.containsKey(letters[k]) ){
                    String str = "" + letters[k] + ch + letters[k];
                    set.add(str);
                }
            }
            
            leftSet.add(ch);
        }
        
        return set.size();
    }

    // public int bruteSolution(String s){

    //     if(s.length()<3){
    //         return 0;
    //     }

    //     HashSet<String> resultSet = new HashSet<>();

    //     for(int i=0; i<s.length()-2; i++){

    //         int j = s.length() -1;
    //         char leftChar = s.charAt(i);

    //         while(j>i+1){
    //             char rightChar = s.charAt(j);

    //             HashSet<Character> set = new HashSet<>();

    //             if(leftChar == rightChar){

    //                 for(int k = i + 1; k < j; k++) {
    //                     set.add(s.charAt(k));
    //                 }

    //                 if(!set.isEmpty()){
    //                     for(char ch : set){
    //                         StringBuilder str = new StringBuilder();
    //                         str.append(leftChar);
    //                         str.append(ch);
    //                         str.append(rightChar);
    //                         resultSet.add(str.toString());
    //                     }
    //                 }
    //                 break;
    //             }
    //             j--;
    //         }
    //     }

    //     return resultSet.size();
    // }

}