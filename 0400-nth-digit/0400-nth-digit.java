class Solution {
    public int findNthDigit(int n) {
        
        // Start with the length of the numbers (1 digit, 2 digits, 3 digits, etc.)
        int digits = 1;
        // Number of numbers with this number of digits
        long count = 9;
        // The starting number for this number of digits (e.g., 1, 10, 100, ...)
        int start = 1;

        // Step 1: Find out how many digits the number at position 'n' belongs to
        while (n > count * digits) {
            n -= count * digits;
            digits++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number 'num' to which the nth digit belongs
        int num = start + (n - 1) / digits;

        // Step 3: Find the nth digit within the number 'num'
        return String.valueOf(num).charAt((n - 1) % digits) - '0';
    }
}