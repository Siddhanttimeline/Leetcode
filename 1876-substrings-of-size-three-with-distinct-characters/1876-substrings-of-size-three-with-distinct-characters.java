class Solution {
    public int countGoodSubstrings(String s) {
        
        int i=0;
        int j=2;
        int count =0;

        while(j < s.length()){
            HashSet<Character> set = new HashSet<>();

            int k =i;

            while(k <= j){
                if( !set.contains(s.charAt(k))){
                    set.add(s.charAt(k));
                    k++;
                }else{
                    break;
                }
            }
            if(k == j+1){
                count++;
            }
            i++;
            j=i+2;
        }

        return count;
    }
}