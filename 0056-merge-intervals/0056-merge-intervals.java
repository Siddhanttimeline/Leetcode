class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();

        for(int[] val : intervals){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < val[0] ){
                merged.add(val);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],val[1]);
            }
        }

        return merged.toArray( new int[0][] );
    }
}