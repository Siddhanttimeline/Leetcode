class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        for(int val : set1){
            if(!set2.contains(val)){
                answer0.add(val);
            }
        }

        for(int val : set2){
            if(!set1.contains(val)){
                answer1.add(val);
            }
        }
    
        List<List<Integer>> result = new ArrayList<>();
        result.add(answer0);
        result.add(answer1);

        return result;

    }
}