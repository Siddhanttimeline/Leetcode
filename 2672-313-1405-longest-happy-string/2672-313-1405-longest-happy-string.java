class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        if (a > 0)
            maxHeap.add(new Pair('a', a));
        if (b > 0)
            maxHeap.add(new Pair('b', b));
        if (c > 0)
            maxHeap.add(new Pair('c', c));

        StringBuilder str = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();

            if (str.length() >= 2 && str.charAt(str.length() - 1) == current.ch
                    && str.charAt(str.length() - 2) == current.ch) {
                if (maxHeap.isEmpty()) {
                    break;
                }

                Pair secondPair = maxHeap.poll();
                str.append(secondPair.ch);
                secondPair.freq--;

                if (secondPair.freq > 0) {
                    maxHeap.add(secondPair);
                }

                maxHeap.add(current);
            } else {
                str.append(current.ch);
                current.freq--;
                if (current.freq > 0) {
                    maxHeap.add(current);
                }
            }

        }

        return str.toString();
    }
}