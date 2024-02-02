class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for (int val : nums) {
            if (val == 0) {
                product = 0;
                break;
            }
            if (val < 0) {
                product *= -1;
            }
        }
        return signFunc(product);
    }

    public static int signFunc(int a) {
        if (a > 0) {
            return 1;
        } else if (a < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
