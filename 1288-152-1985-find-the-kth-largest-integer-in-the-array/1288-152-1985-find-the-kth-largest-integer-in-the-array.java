class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }

            return Integer.compare(a.length(), b.length());
        });
        
        for (String val : nums) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}