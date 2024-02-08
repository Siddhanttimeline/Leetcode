class Solution {
    public int mySqrt(int x) {
        long low = 1;
        long high = x;
        long ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }

        return (int) ans;
    }
}
