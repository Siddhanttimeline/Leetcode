class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        HashMap<String,List<String>> map = new HashMap<>();
        // List<List<String>> result = new ArrayList<>();

        for(String str : strs){

            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String modifiedStr = new String(charArr);

            if( !map.containsKey(modifiedStr) ){
                map.put(modifiedStr, new ArrayList<>());
            }

            map.get(modifiedStr).add(str);

            // if(map.containsKey(modifiedStr)){
            //     map.get(modifiedStr).add(str);
            // }else{
            //     map.put(modifiedStr,new ArrayList<>());
            //     map.get(modifiedStr).add(str);
            // }

        }


        // for(List<String> list : map.values()){
        //     result.add(list);
        // }

        return new ArrayList<>(map.values());

    }
}