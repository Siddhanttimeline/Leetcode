class Solution {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        long exp = n;

        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        return calculate(x, exp);
    }

    private double calculate(double x, long exp) {
        if (exp == 0)
            return 1.0;

        double y = calculate(x, exp / 2);

        return ((exp & 1) == 1) ? y * y * x : y * y;
    }

    // public double myPow(double x, int n) {
    // if (n == 0)
    // return 1;

    // long exp = n;

    // if (exp < 0) {
    // x = 1 / x;
    // exp = -exp;
    // }

    // double result = 1.0;
    // double currentProduct = x;

    // while (exp > 0) {
    // if ((exp & 1) == 1) {
    // result *= currentProduct;
    // }

    // exp /= 2;
    // currentProduct *= currentProduct;
    // }

    // return result;
    // }
}