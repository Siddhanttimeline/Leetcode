class Solution {
    public int partitionString(String s) {
        
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(!set.contains(ch)){
                set.add(ch);
            }else{
                count++;
                set.clear();
                set.add(ch);
            }
        }

        if(!set.isEmpty()){
            count++;
        }

        return count;

    }
}