class Solution {
    public int maxNumberOfBalloons(String text) {
        
        String b = "balloon";
        HashSet<Character> set = new HashSet<>();
        for(char c :  b.toCharArray()){
            set.add(c);
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            if(set.contains(ch)){
                map.put(ch,map.getOrDefault(ch,0) + 1);
            }
        }

        if(map.size() < 5){
            return 0;
        }

        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {   
            if(entry.getKey() == 'l' || entry.getKey() == 'o'){
                int value = entry.getValue();
                int afterDivide = value/2;
                 minValue =Math.min(minValue,afterDivide);
            }else{
                int value = entry.getValue();
                 minValue = Math.min(minValue,value);
            }
        }

        return minValue;
        
    }
}