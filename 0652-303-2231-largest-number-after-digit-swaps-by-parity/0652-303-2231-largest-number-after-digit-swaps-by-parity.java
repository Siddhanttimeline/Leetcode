class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Character> evenList = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Character> oddList = new PriorityQueue<>((a, b) -> b - a);

        char[] numbers = String.valueOf(num).toCharArray();

        for (char digit : numbers) {
            if ((digit - '0') % 2 == 0) {
                evenList.add(digit);
            } else {
                oddList.add(digit);
            }
        }

        StringBuilder str = new StringBuilder();

        for (char digit : numbers) {
            if ((digit - '0') % 2 == 0) {
                str.append(evenList.poll());
            } else {
                str.append(oddList.poll());
            }
        }

        return Integer.parseInt(str.toString());
    }
}