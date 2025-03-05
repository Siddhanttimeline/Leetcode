class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2)
            return "";

        StringBuilder result = new StringBuilder();
        Character prev = null;

        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            result.append(ch);
            freqMap.put(ch, freqMap.get(ch) - 1);

            if (prev != null && freqMap.get(prev) > 0) {
                maxHeap.add(prev);
            }

            prev = (freqMap.get(ch) > 0) ? ch : null;
        }

        return result.toString();
    }
}
