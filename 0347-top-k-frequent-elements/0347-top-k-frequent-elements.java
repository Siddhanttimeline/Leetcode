class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        List<Integer> sublistValues = new ArrayList<>(values.subList(0, k));

        int index = 0;
        int[] result = new int[k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(sublistValues.contains(entry.getValue())){
                result[index] = entry.getKey();
                index++;
            }
        }

        return result;
    }
}