class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Destroy the smaller asteroid
                }
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // Add the left-moving asteroid to the stack
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // Destroy both asteroids if they are of the same size
                }
            }
        }
        
        // Convert the stack to an array
        int[] result = new int[stack.size()];
        int pointer = 0;
        for (int val : stack) {
            result[pointer] = val;
            pointer++;
        }

        return result;
    }
}
